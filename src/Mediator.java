import java.util.ArrayList;
import java.util.List;

import datastoreapi.DataStoreAPI;
import datastoreapi.InputRequest;
import datastoreapi.OutputRequest;
import interfaces.NumStream;

public class Mediator {
	
	private static Mediator mediator = new Mediator(new DataStoreAPI(), new ComputeEngineImplementation(new ComputationImplementation(), new ComputeRequestHandlerImplementation()));
	
	private DataStoreAPI dataStoreApi;
	
	private ComputeEngine computeEngine;
	
	public Mediator(DataStoreAPI dataStoreApi, ComputeEngine computeEngine) {
		this.dataStoreApi = dataStoreApi;
		this.computeEngine = computeEngine;
	}
	
	public static Mediator getMediator() {
		return mediator;
	}
	
	public static void setMediator(Mediator replacementMediator) {
		mediator = replacementMediator;
	}
	
	public <T> void sendInput(UserRequestProvider<T> provider) {
		UserRequest userRequest = provider.generateRequest(provider.getInput());
		UserRequestDestination destination = userRequest.getUserRequestDestination();
		UserRequestSource source = userRequest.getUserRequestSource();
		EngineResponse response = new ConcreteEngineResponse(ResponseCode.FAILED);
		if (source instanceof FileUserRequestSource fileSource && destination instanceof FileUserRequestDestination fileDestination) {
			InputRequest inputRequest = new InputRequest(fileSource.getFileName());
			List<Integer> inputList = dataStoreApi.readInput(inputRequest);
			NumStream inputNumStream = new NumStreamImplementation();
			inputNumStream.setIntegerList(inputList);
			EngineResponse engineResponse = computeEngine.submitRequest(userRequest);
			dataStoreApi.setOutputList(List.of(engineResponse.getRequestResult().getResultString()));
			OutputRequest outputRequest = new OutputRequest(fileDestination.getFileName());
			List<String> outputList = dataStoreApi.writeOutput(outputRequest);
			if (!outputList.isEmpty()) {
				response.setResponseCode(ResponseCode.SUCCESSFUL); 
				response.setRequestResult(engineResponse.getRequestResult());
			}
		} else {
			response = new ConcreteEngineResponse(ResponseCode.UNIMPLEMENTED);
		}
		provider.propigateResponse(response);
	}
	
}

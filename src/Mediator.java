import java.util.ArrayList;
import java.util.List;

import datastoreapi.DataStoreAPI;
import datastoreapi.InputRequest;
import datastoreapi.OutputRequest;
import interfaces.NumStream;

public class Mediator {
	
	private static Mediator mediator = new Mediator(new DataStoreAPI(), new ComputationImplementation());
	
	private DataStoreAPI dataStoreApi;
	
	private ComputeEngineComputation computeEngine;
	
	public Mediator(DataStoreAPI dataStoreApi, ComputeEngineComputation computeEngine) {
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
			NumStream outputNumStream = computeEngine.doFactorial(inputNumStream).getRequestResult().getResultNumStream();
			OutputRequest outputRequest = new OutputRequest(fileDestination.getFileName());
			dataStoreApi.setOutputList(toStringList(outputNumStream));
			List<String> outputList = dataStoreApi.writeOutput(outputRequest);
			if (!outputList.isEmpty()) {
				response = new ConcreteEngineResponse(ResponseCode.SUCCESSFUL);
			}
		} else {
			response = new ConcreteEngineResponse(ResponseCode.UNIMPLEMENTED);
		}
		provider.propigateResponse(response);
	}
	
	private List<String> toStringList(NumStream stream){
		List<Integer> integers = stream.getIntegers();
		List<String> strings = new ArrayList<>();
		for (Integer integer : integers) {
			strings.add(String.valueOf(integer));
		}
		return strings;

	}
	
}

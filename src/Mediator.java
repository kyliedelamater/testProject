import java.util.List;
import java.util.Optional;

import datastoreapi.DataStoreAPI;
import datastoreapi.InputRequest;
import datastoreapi.OutputRequest;
import interfaces.NumStream;

public class Mediator {

	private static Mediator mediator = new Mediator(new DataStoreAPI(), new ComputeEngineImplementation(new ComputationImplementation(), new ComputeRequestHandlerImplementation()));

	private DataStoreAPI dataStoreApi;

	private ComputeEngine computeEngine;

	public Mediator(DataStoreAPI dataStoreApi, ComputeEngine computeEngine) {
		if(dataStoreApi == null)) {
			throw new IllegalArgumentException("DataStoreAPI cannot be null");
		}
		if(computeEngine == null) {
			throw new IllegalArgumentException("ComputeEngine cannot be null");
		}
		this.dataStoreApi = dataStoreApi;
		this.computeEngine = computeEngine;
	}

	public static Mediator getMediator() {
		return mediator;
	}

	public static void setMediator(Mediator replacementMediator) {
		if(replacementMediator == null) {
			throw new IllegalArgumentException("Mediator cannot be null");
		}
		mediator = replacementMediator;
	}

	public <T> void sendInput(UserRequestProvider<T> provider) {
		if(provider == null) {
			throw new IllegalArgumentException("UserRequestProvider cannot be null");
		}
		UserRequest userRequest = provider.generateRequest(provider.getInput());

		EngineResponse response = new ConcreteEngineResponse(ResponseCode.FAILED);

		Optional<InputRequest> inRequest = generateInputRequest(userRequest);

		NumStream inputNumStream = new NumStreamImplementation();

		if (inRequest.isPresent()) {
			List<Integer> inputList = dataStoreApi.readInput(inRequest.get());
			inputNumStream.setIntegerList(inputList);
		}

		userRequest.setRequestStream(inputNumStream);

		EngineResponse engineResponse = computeEngine.submitRequest(userRequest);

		if (!engineResponse.getResponseCode().isFailure()) {
			Optional<OutputRequest> outRequest = generateOutputRequest(userRequest);
			if (outRequest.isPresent()) {
				dataStoreApi.setOutputList(List.of(engineResponse.getRequestResult().getResultString()));
				dataStoreApi.writeOutput(outRequest.get());
				response.setResponseCode(ResponseCode.SUCCESSFUL); 
				response.setRequestResult(engineResponse.getRequestResult());
			}
		}

		provider.propigateResponse(response);
	}

	private Optional<InputRequest> generateInputRequest(UserRequest request) {
		if(request == null) {
			throw new IllegalArgumentException("UserRequest cannot be null");
		}
		if (request.getUserRequestSource() instanceof FileUserRequestSource fileSource) {
			return Optional.of(new InputRequest(fileSource.getFileName()));
		}
		return Optional.empty();
	}

	private Optional<OutputRequest> generateOutputRequest(UserRequest request) {
		if(request == null) {
			throw new IllegalArgumentException("UserRequest cannot be null");
		}
		if (request.getUserRequestDestination() instanceof FileUserRequestDestination fileDestination) {
			return Optional.of(new OutputRequest(fileDestination.getFileName()));
		}
		return Optional.empty();
	}

}

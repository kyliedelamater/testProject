import datastoreapi.DataStoreAPI;

public class UserIOApi {

	private ComputeEngine computeEngine;

	public UserIOApi(ComputeEngine computeEngine) {
		this.computeEngine = computeEngine;
	}

	public UserIOApi(){
		this.computeEngine = new ComputeEngineImplementation(new ComputationImplementation(), new ComputeRequestHandlerImplementation(), new DataStoreAPI());
	}

	public ComputeEngine getComputeEngineApi() {
		return computeEngine;
	}

	public void setComputeEngineApi(ComputeEngineApi computeEngineApi) {
		this.computeEngine = computeEngine;
	}
	
	public EngineResponse sendRequest(UserRequest request) {
		return sendRequest(request, false);
	}

	public EngineResponse sendRequest(UserRequest request, boolean internalRequest) {
		return computeEngine.submitRequest(request, internalRequest);
	}
}

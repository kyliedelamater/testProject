public class UserIOApi {

	private ComputeEngineApi computeEngineApi;

	public UserIOApi(ComputeEngineApi computeEngineApi) {
		this.computeEngineApi = computeEngineApi;
	}

	public UserIOApi(){
	}

	public ComputeEngineApi getComputeEngineApi() {
		return computeEngineApi;
	}

	public void setComputeEngineApi(ComputeEngineApi computeEngineApi) {
		this.computeEngineApi = computeEngineApi;
	}
	
	public EngineResponse sendRequest(UserRequest request) {
		return null;
	}

}

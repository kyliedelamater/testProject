
public class ConcreteEngineResponse implements EngineResponse{
	
	private ResponseCode responseCode;

	private RequestResult requestResult;
	
	public ConcreteEngineResponse(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}

	@Override
	public ResponseCode getResponseCode() {
		return this.responseCode;
	}

	@Override
	public RequestResult getRequestResult() {
		return this.requestResult;
	}

}

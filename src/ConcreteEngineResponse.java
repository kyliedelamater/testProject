
public class ConcreteEngineResponse implements EngineResponse {
	
	private ResponseCode responseCode;

	private RequestResult requestResult;
	
	public ConcreteEngineResponse(ResponseCode responseCode) {
		if(ResponseCode == null) {
			throw new IllegalArgumentException("ResponseCode cannot be null");
		}
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

	@Override
	public void setResponseCode(ResponseCode responseCode) {
		if(responseCode == null) {
			throw new IllegalArgumentException("ResponseCode cannot be null");
		}
		this.responseCode = responseCode;
	}

	@Override
	public void setRequestResult(RequestResult requestResult) {
		if(requestResult == null) {
			throw new IllegalArgumentException("RequestResult cannot be null");
		}
		this.requestResult = requestResult;
	}

}

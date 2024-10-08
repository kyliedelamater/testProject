
public class EngineResponseExceptionImplementation implements EngineResponseException{
	
	private Exception exception;
	private ResponseCode responseCode = ResponseCode.FAILED;
	private RequestResult requestResult;

	public EngineResponseExceptionImplementation(Exception exception) { 
		this.exception = exception;
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
		this.responseCode = responseCode;
	}

	@Override
	public void setRequestResult(RequestResult requestResult) {
		this.requestResult = requestResult;
	}

	@Override
	public Exception getException() {
		return this.exception;
	}

	@Override
	public void setException(Exception exception) {
		this.exception = exception;
	}

}

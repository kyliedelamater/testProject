
public class EngineResponseException extends ConcreteEngineResponse{

	private Exception exception;

	public EngineResponseException(Exception exception) {
		super(ResponseCode.FAILED);
		this.exception = exception;
	}
	
	public Exception getException() {
		return this.exception;
	}

}

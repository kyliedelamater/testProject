
public interface EngineResponseException extends EngineResponse{

	public Exception getException();
	
	public void setException(Exception exception);

}

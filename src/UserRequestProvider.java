
public interface UserRequestProvider<T>{
	
	public UserRequest generateRequest(T t);

	public T getInput();
	
	public void propigateResponse(EngineResponse response);

}

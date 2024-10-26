import interfaces.NumStream;

public interface ComputeEngine {

	EngineResponse submitRequest(UserRequest userRequest);

	EngineResponse submitRequest(UserRequest userRequest, boolean internalRequest);

	EngineResponse sendStreamForFactorial(NumStream numStream);
}

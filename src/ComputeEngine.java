import interfaces.NumStream;

public interface ComputeEngine {

	EngineResponse submitRequest(UserRequest userRequest);

	EngineResponse sendStreamForFactorial(NumStream numStream);
}

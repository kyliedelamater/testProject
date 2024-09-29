
public class UserToEnginePrototype {

	
	public static void prototype(ComputeEngine engine) {

		// user submits a UserRequest to the compute engine, returns an EngineResponse
		EngineResponse response = engine.submitRequest(new UserRequest(new UserRequestSource(),new UserRequestDestination()));
		
		// user checks EngineResponse if operation was successful
		if (response.getResponseCode() == ResponseCode.SUCCESSFUL) {

			// user gets result from EngineResponse 
			RequestResult result = response.getRequestResult();

		} else {

			System.err.println("Failed :^(");

		}
		

	}
}

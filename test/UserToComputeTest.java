import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class UserToComputeTest {

	@Test
	public void testUserIOApi() {

		ComputeEngineApi computeEngineApi = mock(ComputeEngineApi.class);
		UserIOApi userIOApi = new UserIOApi(computeEngineApi);
		when(userIOApi.sendRequest(any(UserRequest.class))).thenReturn(mock(EngineResponse.class));

		UserRequest request = new UserRequest(mock(UserRequestSource.class), mock(UserRequestDestination.class));

		EngineResponse response = userIOApi.sendRequest(request);

		assert response != null;

		ResponseCode code = response.getResponseCode();

		assert code != null && existsInResponseCodes(code);

		RequestResult result = response.getRequestResult();

		assert result != null;

	}
	
	public boolean existsInResponseCodes(ResponseCode responseCode) {
		for (ResponseCode existingCode : ResponseCode.values()) {
			if (responseCode == existingCode) {
				return true;
			}
		}
		return false;
	}
	
}

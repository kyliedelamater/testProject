import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class UserToComputeTest {

	@Test
	public void testUserIOApi() {

		ComputeEngineApi computeEngineApi = mock(ComputeEngineApi.class);
		UserIOApi mockUserIOApi = mock(UserIOApi.class);

		EngineResponse mockEngineResponse = mock(EngineResponse.class);
    when(mockUserIOApi.sendRequest(any())).thenReturn(mockEngineResponse);
		when(mockEngineResponse.getResponseCode()).thenReturn(ResponseCode.SUCCESSFUL);
		when(mockEngineResponse.getRequestResult()).thenReturn(new RequestResultImplementation());

		UserRequest request = new UserRequest(mock(UserRequestSource.class), mock(UserRequestDestination.class));

		EngineResponse response = mockUserIOApi.sendRequest(request);

		assert response != null;

		ResponseCode code = mockEngineResponse.getResponseCode();

		assert code != null && existsInResponseCodes(code);

		RequestResult result = mockEngineResponse.getRequestResult();

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

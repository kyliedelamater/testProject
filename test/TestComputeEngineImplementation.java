import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;


public class TestComputeEngineImplementation {

  @Test
  public void testComputation() {
    ComputeRequestHandler mockComputeRequestHandler = mock(ComputeRequestHandler.class);
    ComputeEngineImplementation mockComputeEngineImplementation = mock(ComputeEngineImplementation.class);
    RequestResult requestResult = mock(RequestResultImplementation.class);

    EngineResponse fakeEngineResponse = new EngineResponseImplementation();
    fakeEngineResponse.setRequestResult(requestResult);

    when(mockComputeEngineImplementation.sendStreamForFactorial(any())).thenReturn(fakeEngineResponse);
    when(mockComputeRequestHandler.generateAndSendResponseMessage(any())).thenReturn(ResponseCode.SUCCESSFUL);

    EngineResponse engineResponse = mockComputeEngineImplementation.sendStreamForFactorial(mockComputeRequestHandler.getNumStream());

    assertEquals(fakeEngineResponse, engineResponse);
  }
}

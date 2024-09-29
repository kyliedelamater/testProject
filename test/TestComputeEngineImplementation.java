import interfaces.ComputeEngineComputation;
import org.junit.Test;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;


public class TestComputeEngineImplementation {

  @Test
  public void testComputation() {
    ComputeEngineComputation mockComputeEngineComputation = mock(ComputeEngineComputation.class);
    ComputeRequestHandler mockComputeRequestHandler = mock(ComputeRequestHandler.class);

    ComputeEngineImplementation computeEngineImplementation = new ComputeEngineImplementation(mockComputeEngineComputation);

    when(mockComputeRequestHandler.generateAndSendResponseMessage(any())).thenReturn(ResponseCode.SUCCESSFUL);

    EngineResponse engineResponse = computeEngineImplementation.computeInput(mockComputeRequestHandler);

    assertEquals(engineResponse, 1);
  }
}

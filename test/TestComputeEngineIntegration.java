import interfaces.ComputeEngineComputation;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

public class TestComputeEngineIntegration {

  @Test
  public void testComputeEngineIntegration() {
    List<Integer> numStream = List.of(1,10,25);
    ComputeEngineComputation computeEngineComputation = mock(ComputeEngineComputation);

    ComputeEngineComputation computeEngineComputation = new ComputeEngineImplementation();
    // This will become a DatastoreApi object upon merging
    Object dataStoreApi = null;
    UserRequest userRequest = new UserRequest((UserRequestSource) numStream, new UserRequestDestination());

    // Create a computeRequestHandler with userRequest, and set it's datastoreapi
    ComputeRequestHandler computeRequestHandler = new ComputeRequestHandler(userRequest);
    computeRequestHandler.setDataApi(dataStoreApi);

    ComputeEngineImplementation computeEngineImplementation = new ComputeEngineImplementation(computeEngineComputation);

    EngineResponse engineResponse = computeEngineImplementation.computeInput(computeRequestHandler);

    Assert.assertEquals(engineResponse.getRequestResult(), "1;1:10;362800:25;15511210043330985984000000");
  }
}

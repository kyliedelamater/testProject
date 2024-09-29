import datastoreapi.DataStoreAPI;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestComputeEngineIntegration {

  @Test
  public void testComputeEngineIntegration() {
    ArrayList<Integer> requestList = new ArrayList<>(Arrays.asList(1,10,25));

    // Create a computeRequestHandler with userRequest, and set it's datastoreapi
    DataStoreAPI dataStoreApi = new DataStoreAPI();
    ComputeRequestHandler computeRequestHandler = new ComputeRequestHandlerImplementation(requestList);
    computeRequestHandler.setDataApi(dataStoreApi);

    ComputeEngineComputation computationImplementation = new ComputationImplementation();

    ComputeEngine computeEngineImplementation = new ComputeEngineImplementation(computationImplementation, computeRequestHandler);

    EngineResponse engineResponse = computeEngineImplementation.sendStreamForFactorial(computeRequestHandler.getNumStream());

    Assert.assertEquals(engineResponse.getRequestResult(), "1;1:10;362800:25;15511210043330985984000000");
  }
}

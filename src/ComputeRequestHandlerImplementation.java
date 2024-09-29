import datastoreapi.DataStoreAPI;
import interfaces.NumStream;

public class ComputeRequestHandlerImplementation implements ComputeRequestHandler {
  DataStoreAPI dataStoreAPI;
  NumStream requestStream;

  @Override
  public void setNumstream(NumStream numStream) {
    this.requestStream = numStream;
  }

  @Override
  public NumStream getIntegersForFactorial() {
    return requestStream;
  }

  @Override
  public ResponseCode generateAndSendResponseMessage(NumStream computeResults) {
    return null;
  }

  @Override
  public <T> ComputeRequestHandler computeRequestHandler(T userRequest) {
    ComputeRequestHandlerImplementation computeRequestHandlerImplementation;
    computeRequestHandlerImplementation.requestStream = new NumStreamImplementation
  }

  @Override
  public <T> void setDataApi(T dataStorageApi) {
    this.dataStoreAPI = (DataStoreAPI) dataStorageApi;
  }
}

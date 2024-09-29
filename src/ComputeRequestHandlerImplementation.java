import datastoreapi.DataStoreAPI;
import interfaces.NumStream;

import java.util.ArrayList;
import java.util.List;

public class ComputeRequestHandlerImplementation implements ComputeRequestHandler {
  DataStoreAPI dataStoreAPI;
  NumStream requestStream;

  public ComputeRequestHandlerImplementation() {
  }

  public ComputeRequestHandlerImplementation(ArrayList<Integer> requestList) {
    this.requestStream = new NumStreamImplementation(requestList);
  }

  public ComputeRequestHandlerImplementation(DataStoreAPI dataStoreAPI, NumStream requestStream) {
    this.dataStoreAPI = dataStoreAPI;
    this.requestStream = requestStream;
  }

  @Override
  public void setNumstream(NumStream numStream) {
    this.requestStream = numStream;
  }

  @Override
  public NumStream getNumStream() {
    return requestStream;
  }

  @Override
  public ResponseCode generateAndSendResponseMessage(NumStream computeResults) {
    return null;
  }

  @Override
  public <T> void setDataApi(T dataStorageApi) {
    this.dataStoreAPI = (DataStoreAPI) dataStorageApi;
  }
}



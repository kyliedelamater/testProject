import datastoreapi.DataStoreAPI;
import interfaces.NumStream;

import java.util.ArrayList;
import java.util.List;

public class ComputeRequestHandlerImplementation implements ComputeRequestHandler {
  DataStoreAPI dataStoreAPI;
  UserRequest userRequest;

  public ComputeRequestHandlerImplementation() {
  }

  public ComputeRequestHandlerImplementation(UserRequest userRequest) {
    this.userRequest = userRequest;
  }

  public ComputeRequestHandlerImplementation(DataStoreAPI dataStoreAPI, UserRequest userRequest) {
    this.dataStoreAPI = dataStoreAPI;
    this.userRequest = userRequest;
  }

  @Override
  public void setUserRequest(UserRequest userRequest) {
    this.userRequest = userRequest;
  }

  @Override
  public UserRequest getUserRequest() {
    return userRequest;
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



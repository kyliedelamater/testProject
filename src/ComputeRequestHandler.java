import interfaces.NumStream;
import datastoreapi.DataStoreAPI
  
public interface ComputeRequestHandler {
  void setUserRequest(UserRequest userRequest);

  UserRequest getUserRequest();

  ResponseCode generateAndSendResponseMessage(NumStream computeResults);

  <T> void setDataApi(DataStoreAPI dataStorageApi);
}

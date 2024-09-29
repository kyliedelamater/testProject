import interfaces.NumStream;

public interface ComputeRequestHandler {
  void setUserRequest(UserRequest userRequest);

  UserRequest getUserRequest();

  ResponseCode generateAndSendResponseMessage(NumStream computeResults);

  <T> void setDataApi(T dataStorageApi);
}

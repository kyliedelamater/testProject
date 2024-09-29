import interfaces.NumStream;

public interface ComputeRequestHandler {
  void setNumstream(NumStream numStream);

  NumStream getNumStream();

  ResponseCode generateAndSendResponseMessage(NumStream computeResults);

  <T> void setDataApi(T dataStorageApi);
}

import interfaces.NumStream;

public interface ComputeRequestHandler {
  void setNumstream(NumStream numStream);

  NumStream getIntegersForFactorial();

  ResponseCode generateAndSendResponseMessage(NumStream computeResults);

  <T> ComputeRequestHandler computeRequestHandler(T userRequest);

  <T> void setDataApi(T dataStorageApi);
}

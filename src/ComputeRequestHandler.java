import interfaces.NumStream;

public interface ComputeRequestHandler {
  NumStream getIntegersForFactorial();

  ResponseCode generateAndSendResponseMessage(NumStream computeResults);

  <T> ComputeRequestHandler computeRequestHandler(T userRequest);
}

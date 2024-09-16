package interfaces;

public interface ComputeRequestHandler {
  NumStream getIntegersForFactorial();

  void generateAndSendResponseMessage(NumStream computeResults);
}

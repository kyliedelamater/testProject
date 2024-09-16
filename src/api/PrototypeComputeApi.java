package api;

import interfaces.ComputeEngineComputation;
import interfaces.ComputeRequestHandler;
import interfaces.NumStream;

public class PrototypeComputeApi {

  public void prototypeComputeRequest(ComputeRequestHandler computeRequestHandler, ComputeEngineComputation computeEngine) {
    // Get the ints to calculate factorials for, from user request
    NumStream computeEngineInput = computeRequestHandler.getIntegersForFactorial();

    // Send the ints over to the engine for computation
    NumStream computeResult = computeEngine.doFactorial(computeEngineInput);

    // Generate a response string and pass it along
    computeRequestHandler.generateAndSendResponseMessage(computeResult);
  }
}

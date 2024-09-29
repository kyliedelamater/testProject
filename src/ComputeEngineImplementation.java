import interfaces.NumStream;

import java.util.ArrayList;

public class ComputeEngineImplementation implements ComputeEngine {
  ComputeEngineComputation computeEngineComputation;
  ComputeRequestHandler computeRequestHandler;

  public ComputeEngineImplementation(ComputeEngineComputation computeEngineComputation, ComputeRequestHandler computeRequestHandler) {
    this.computeEngineComputation = computeEngineComputation;
    this.computeRequestHandler = computeRequestHandler;
  }

  public ComputeEngineImplementation(ComputeEngineComputation computeEngineComputation) {
    this.computeEngineComputation = computeEngineComputation;
  }

  public ComputeEngineComputation getComputeEngineComputation() {
    return computeEngineComputation;
  }

  public void setComputeEngineComputation(ComputeEngineComputation computeEngineComputation) {
    this.computeEngineComputation = computeEngineComputation;
  }

  @Override
  public EngineResponse submitRequest(UserRequest userRequest) {
    EngineResponse engineResponse = sendStreamForFactorial(userRequest.getRequestStream());
    NumStream resultStream = engineResponse.getRequestResult().getResultNumStream();

    RequestResult requestResult = engineResponse.getRequestResult();

    requestResult.setResultString(processResultString(userRequest, (ArrayList<Integer>) resultStream.getIntegers()));

    return engineResponse;
  }

  @Override
  public EngineResponse sendStreamForFactorial(NumStream numStream) {
    return computeEngineComputation.doFactorial(numStream);
  }

  public String processResultString(UserRequest userRequest, ArrayList<Integer> resultList) {
    ArrayList<Integer> requestStream = (ArrayList<Integer>) userRequest.getRequestStream().getIntegers();
    StringBuilder result = new StringBuilder();
    int resultPosition = 0;

    for (Integer requestInteger : requestStream) {
      result.append(requestInteger);
      result.append(userRequest.resultDelimiter);
      result.append(resultList.get(resultPosition));

      if(requestStream.size() > resultPosition + 1) {
        result.append(userRequest.pairDelimiter);
      }

      resultPosition++;
    }

    return result.toString();
  }
}

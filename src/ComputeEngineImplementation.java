import interfaces.ComputeEngineComputation;

public class ComputeEngineImplementation {
  PrototypeComputeApi computeEngineApi;
  ComputeEngineComputation computeEngineComputation;
  ComputeRequestHandler computeRequestHandler;

  EngineResponse computeInput(UserRequest userRequest) {
    computeEngineApi.prototypeComputeRequest(computeRequestHandler.computeRequestHandler(userRequest), computeEngineComputation);

    // Temporary return for tests
    return null;
  }

  public ComputeEngineImplementation(ComputeEngineComputation computeEngineComputation, ComputeRequestHandler computeRequestHandler) {
    this.computeEngineApi = new PrototypeComputeApi();
    this.computeEngineComputation = computeEngineComputation;
    this.computeRequestHandler = computeRequestHandler;
  }

  public PrototypeComputeApi getComputeEngineApi() {
    return computeEngineApi;
  }

  public void setComputeEngineApi(PrototypeComputeApi computeEngineApi) {
    this.computeEngineApi = computeEngineApi;
  }

  public ComputeEngineComputation getComputeEngineComputation() {
    return computeEngineComputation;
  }

  public void setComputeEngineComputation(ComputeEngineComputation computeEngineComputation) {
    this.computeEngineComputation = computeEngineComputation;
  }

  public ComputeRequestHandler getComputeRequestHandler() {
    return computeRequestHandler;
  }

  public void setComputeRequestHandler(ComputeRequestHandler computeRequestHandler) {
    this.computeRequestHandler = computeRequestHandler;
  }
}

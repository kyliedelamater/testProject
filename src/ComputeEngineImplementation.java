import interfaces.ComputeEngineComputation;

public class ComputeEngineImplementation {
  ComputeEngineComputation computeEngineComputation;

  EngineResponse computeInput(ComputeRequestHandler ComputeRequestHandler) {
    return null;
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
}

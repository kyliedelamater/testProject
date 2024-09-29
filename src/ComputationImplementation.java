import interfaces.NumStream;

import java.util.ArrayList;

public class ComputationImplementation implements ComputeEngineComputation {
  @Override
  public EngineResponse doFactorial(NumStream numStream) {
    NumStream answerStream = new NumStreamImplementation();
    ArrayList<Integer> resultList = new ArrayList<>();

    answerStream.setIntegerList(resultList);

    return new EngineResponseImplementation(ResponseCode.SUCCESSFUL, resultList);
  }

  public void factorialLoop(ArrayList<Integer> inputList, ArrayList<Integer> resultList) {
    for (Integer inputNum : inputList) {
      int result = 1;
      for (int interval = inputNum; interval > 0; interval--) {
        result = result * interval;
      }

      resultList.add(result);
    }
  }
}

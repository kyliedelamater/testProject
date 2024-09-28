import interfaces.ComputeEngineComputation;
import interfaces.NumStream;

import java.util.ArrayList;

public class ComputationImplementation {
  public NumStreamImplementation doFactorial(NumStreamImplementation numStream) {
    NumStreamImplementation answerStream = new NumStreamImplementation();
    ArrayList<Integer> resultList = new ArrayList<>();

    for (Integer inputNum : numStream.getNumStream()) {
      int result = 1;
      for (int interval = inputNum; interval > 0; interval--) {
        result = result * interval;
      }

      resultList.add(result);
    }

    answerStream.setNumStream(resultList);

    return answerStream;
  }
}

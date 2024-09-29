import interfaces.NumStream;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RequestResultImplementation implements RequestResult {
  NumStream result;
  String resultString;

  public RequestResultImplementation() {
  }

  public RequestResultImplementation(ArrayList<Integer> result) {
    this.result = new NumStreamImplementation(result);
  }

  public NumStream getResultNumStream() {
    return result;
  }

  @Override
  public String getResultString() {
    return resultString;
  }

  public void setResultNumStream(NumStream resultNumStream) {
    this.result = result;
  }

  public void setResultString(String resultString) {
    this.resultString = resultString;
  }
}

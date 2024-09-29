import interfaces.NumStream;

import java.util.ArrayList;
import java.util.List;

public class NumStreamImplementation implements NumStream {
  public List<Integer> integerList;

  public NumStreamImplementation() {
  }

  public NumStreamImplementation(List<Integer> integerList) {
    this.integerList = integerList;
  }

  public List<Integer> getIntegers() {
    return integerList;
  }

  public void setIntegerList(List<Integer> integerList) {
    this.integerList =  integerList;
  }
}

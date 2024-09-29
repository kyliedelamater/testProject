import interfaces.NumStream;

import java.util.ArrayList;

public class NumStreamImplementation implements NumStream {
  public List<Integer> integerList;

  public NumStreamImplementation() {
  }

  public NumStreamImplementation(List<Integer> integerList) {
    this.integerList = integerList;
  }

  @Override
  public Object getIntegers() {
    return integerList;
  }

  @Override
  public void setIntegerList(List<Integer> integerList) {
    this.integerList =  integerList;
  }
}

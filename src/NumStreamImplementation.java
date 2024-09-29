import interfaces.NumStream;

import java.util.ArrayList;

public class NumStreamImplementation implements NumStream {
  public ArrayList<Integer> integerList;

  public NumStreamImplementation() {
  }

  public NumStreamImplementation(ArrayList<Integer> integerList) {
    this.integerList = integerList;
  }

  @Override
  public Object getIntegers() {
    return integerList;
  }

  @Override
  public void setIntegerList(Object integerList) {
    this.integerList = (ArrayList<Integer>) integerList;
  }
}

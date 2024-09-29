import interfaces.NumStream;

public interface RequestResult {
  public NumStream getResultNumStream();

  public String getResultString();

  public void setResultString(String resultString);
}

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EngineResponseImplementation implements EngineResponse {
  ResponseCode responseCode;
  RequestResult requestResult;

  public EngineResponseImplementation() {
  }

  public EngineResponseImplementation(ResponseCode responseCode, ArrayList<Integer> requestResult) {
    this.responseCode = responseCode;
    this.requestResult = new RequestResultImplementation(requestResult);
  }

  public void setRequestResult (ArrayList<Integer> result) {
    this.requestResult = new RequestResultImplementation(result);
  }

  public void setResponseCode(ResponseCode responseCode) {
    this.responseCode = responseCode;
  }

  @Override
  public ResponseCode getResponseCode() {
    return null;
  }

  @Override
  public RequestResult getRequestResult() {
    return null;
  }
}

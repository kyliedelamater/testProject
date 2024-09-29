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

  @Override
  public void setRequestResult(RequestResult result) {
    this.requestResult = result;
  }

  @Override
  public void setResponseCode(ResponseCode responseCode) {
    this.responseCode = responseCode;
  }

  @Override
  public ResponseCode getResponseCode() {
    return this.responseCode;
  }

  @Override
  public RequestResult getRequestResult() {
    return this.requestResult;
  }
}

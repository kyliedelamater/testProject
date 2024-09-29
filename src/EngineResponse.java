
public interface EngineResponse {

	ResponseCode getResponseCode();

	RequestResult getRequestResult();

	void setResponseCode(ResponseCode responseCode);

	void setRequestResult(RequestResult requestResult);
}

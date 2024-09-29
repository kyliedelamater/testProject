import interfaces.NumStream;

public class UserRequest {
	NumStream requestStream;
	char resultDelimiter;
	char pairDelimiter;

	public UserRequest(UserRequestSource userRequestSource, UserRequestDestination userRequestDestination, char resultDelimiter,
			char pairDelimiter) {
		this.resultDelimiter = resultDelimiter;
		this.pairDelimiter = pairDelimiter;
	}

	public UserRequest(UserRequestSource userRequestSource, UserRequestDestination userRequestDestination) {
		this(userRequestSource, userRequestDestination, ';', ':');
	}

	public NumStream getRequestStream() {
		return requestStream;
	}

	public void setRequestStream(NumStream requestStream) {
		this.requestStream = requestStream;
	}
}

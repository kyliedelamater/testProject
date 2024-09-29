import interfaces.NumStream;

public class UserRequest {
	private NumStream requestStream;
	private UserRequestSource userRequestSource;
	private UserRequestDestination userRequestDestination;
	private char resultDelimiter;
	private char pairDelimiter;

	public UserRequest(NumStream requestStream, UserRequestSource userRequestSource, UserRequestDestination userRequestDestination, char resultDelimiter,
			char pairDelimiter) {
		this.requestStream = requestStream;
		this.pairDelimiter = pairDelimiter;
		this.resultDelimiter = resultDelimiter;
		this.userRequestDestination = userRequestDestination;
		this.userRequestSource = userRequestSource;
	}

	public UserRequest(UserRequestSource userRequestSource, UserRequestDestination userRequestDestination, NumStream requestStream) {
		this(requestStream, userRequestSource, userRequestDestination, ';', ':');
	}

	public UserRequest(UserRequestSource userRequestSource, UserRequestDestination userRequestDestination) {
		this.userRequestSource = userRequestSource;
		this.userRequestDestination = userRequestDestination;
	}

	public NumStream getRequestStream() {
		return requestStream;
	}

	public void setRequestStream(NumStream requestStream) {
		this.requestStream = requestStream;
	}
	
	public UserRequestSource getUserRequestSource() {
		return userRequestSource;
	}

	public UserRequestDestination getUserRequestDestination() {
		return userRequestDestination;
	}

	public char getResultDelimiter() {
		return resultDelimiter;
	}

	public char getPairDelimiter() {
		return pairDelimiter;
	}
}

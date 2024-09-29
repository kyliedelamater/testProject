
public class UserRequest {
	
	private UserRequestSource userRequestSource;
	private UserRequestDestination userRequestDestination;
	private char resultDelimiter;
	private char pairDelimiter;

	public UserRequest(UserRequestSource userRequestSource, UserRequestDestination userRequestDestination, char resultDelimiter,
			char pairDelimiter) {
		this.pairDelimiter = pairDelimiter;
		this.resultDelimiter = resultDelimiter;
		this.userRequestDestination = userRequestDestination;
		this.userRequestSource = userRequestSource;
	}

	public UserRequest(UserRequestSource userRequestSource, UserRequestDestination userRequestDestination) {
		this(userRequestSource, userRequestDestination, ';', ':');
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


public class UserRequest {

	public UserRequest(UserRequestSource userRequestSource, UserRequestDestination userRequestDestination, char resultDelimiter,
			char pairDelimiter) {

	}

	public UserRequest(UserRequestSource userRequestSource, UserRequestDestination userRequestDestination) {
		this(userRequestSource, userRequestDestination, ';', ':');
	}

}

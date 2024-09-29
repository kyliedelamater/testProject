
public enum ResponseCode {

	SUCCESSFUL(false),
	FAILED(true),
	UNIMPLEMENTED(true);
	
	private final boolean failure;
	
	private ResponseCode(boolean failure) {
		this.failure = failure;
	}
	
	public boolean isFailure() {
		return this.failure;
	}
	
}

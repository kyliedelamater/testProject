package datastoreapi;

public class InputRequest {
	private String file;

	public InputRequest(String file) {
		this.setFile(file);
	}

	public InputRequest() {
		return;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}

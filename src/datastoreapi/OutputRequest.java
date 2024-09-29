package datastoreapi;

public class OutputRequest {
	private String file;

	public OutputRequest(String file) {
		this.setFile(file);
	}

	public OutputRequest() {
		return;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}

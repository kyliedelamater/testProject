
public class FileUserRequestSource extends UserRequestSource {

	private String fileName;

	public FileUserRequestSource(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

}

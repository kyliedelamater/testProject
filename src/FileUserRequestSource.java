
public class FileUserRequestSource extends UserRequestSource {

	private String fileName;

	public FileUserRequestSource(String fileName) {
		if(fileName == null || fileName.isEmpty()) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

}

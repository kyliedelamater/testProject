
public class FileUserRequestDestination extends UserRequestDestination {

	private String fileName;

	public FileUserRequestDestination(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

}

import interfaces.NumStream;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestUser {
	
	// TODO 3: change the type of this variable to the name you're using for your
	// User <-> ComputeEngine API; also update the parameter passed to the constructor
	private final UserIOApi coordinator;

	public TestUser(UserIOApi coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';
		String inputPath = "test" + File.separatorChar + "testInputFile.test";
		
		// TODO 4: Call the appropriate method(s) on the coordinator to get it to 
		// run the compute job specified by inputPath, outputPath, and delimiter
		UserRequestSource userRequestSource = new FileUserRequestSource(inputPath);
		UserRequestDestination userRequestDestination = new UserRequestDestination(outputPath);
		NumStream inputStream = new NumStreamImplementation();
		inputStream.setIntegerList(new ArrayList<>(List.of(1,3)));

		UserRequest userRequest = new UserRequest(userRequestSource, userRequestDestination, delimiter, inputStream);
		coordinator.sendRequest(userRequest, true);
	}

}

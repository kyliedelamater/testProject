package datastoreapi;

import java.util.ArrayList;
import java.util.List;

public class OutputInMemoryImplementation {

	List<String> outputConfig = new ArrayList<>();
	
	public void writeOutput(String output) {
		outputConfig.add(output);
	}
}


package datastoreapitests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class DataStoreInMemoryImplementation {

	@Test
	public void readAndWriteData() {
		List<Integer> inputList = new ArrayList<>();
		List<String> outputList = new ArrayList<>();
		
		datastoreapitests.InputInMemoryImplementation input = new datastoreapitests.InputInMemoryImplementation(inputList);
		datastoreapitests.OutputInMemoryImplementation output = new datastoreapitests.OutputInMemoryImplementation(outputList);
		
		int i = inputList.size();
		while(!inputList.isEmpty()) {
			input.readInput();
			inputList.remove(i);
			i--;
		}
		
		for (int k = 0; k < inputList.size(); k++) {
			output.writeOutput(outputList);
		}
	}

}

package datastoreapitests;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DataStoreInMemoryImplementation {

	@Test
	public void readAndWriteData() {
		List<Integer> inputList = new ArrayList<>();
		List<String> outputList = new ArrayList<>();
		
		InputInMemoryImplementation input = new InputInMemoryImplementation(inputList);
		OutputInMemoryImplementation output = new OutputInMemoryImplementation(outputList);
		
		int i = inputList.size();
		while(inputList.isEmpty() == false) {
			input.readInput();
			inputList.remove(i);
			i--;
		}
		
		for (int k = 0; k < inputList.size(); k++) {
			output.writeOutput(outputList);
		}
	}

}

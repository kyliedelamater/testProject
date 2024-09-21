package datastoreapi;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DataStoreInMemoryImplementation {
	private Input input;
	private Output output;
		
		@Test
		public void readAndWriteData() {
			List<Integer> input2 = input.readInput();

			for(int i = 0; i < input2.size(); i++) {
				String outputData = "Output = " + input2.get(i);
				output.writeOutput(outputData);
			}
		}

}

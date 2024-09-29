import java.util.List;

import org.junit.jupiter.api.Test;

public class DataStoreInMemoryImplementation {
	private datastoreapi.InputInMemoryImplementation input;
	private datastoreapi.OutputInMemoryImplementation output;
		
		@Test
		public void readAndWriteData() {
			List<Integer> input2 = input.getInput();

			for(int i = 0; i < input2.size(); i++) {
				String outputData = "Output = " + input2.get(i);
				output.writeOutput(outputData);
			}
		}

}

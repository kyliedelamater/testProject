import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class DataStoreInMemoryImplementation {
	private InputInMemoryImplementation input = new InputInMemoryImplementation();
	private OutputInMemoryImplementation output = new OutputInMemoryImplementation();

		@Test
		public void readAndWriteData() {
			input.inputConfig = new ArrayList<>(Stream.of(1,2,3).toList());

			List<Integer> input2 = input.getInput();

			for(int i = 0; i < input2.size(); i++) {
				String outputData = "Output = " + input2.get(i);
				output.writeOutput(outputData);
			}
		}

}

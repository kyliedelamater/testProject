package datastoreapitests;

import java.util.List;

public class OutputInMemoryImplementation {

	private List<String> outputConfig;
	
	public OutputInMemoryImplementation(List<String> outputConfig) {
		this.outputConfig = outputConfig;
	}

	public void writeOutput(List<String> output) {
		outputConfig.addAll(output);
	}

	public List<String> getOutputConfig() {
		return outputConfig;
	}
}

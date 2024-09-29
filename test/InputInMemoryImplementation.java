package datastoreapitests;

import java.util.List;

public class InputInMemoryImplementation {

	private List<Integer> inputConfig;

	public InputInMemoryImplementation(List<Integer> inputConfig){
		this.inputConfig = inputConfig;

	}

	public List<Integer> readInput() {
		return inputConfig;
	}
}

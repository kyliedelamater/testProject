package datastoreapi;

import java.util.*;

public class DataStoreAPI {
	
	//list where the inputs will be stored
	private List<Integer> inputList = new ArrayList<>();
	
	//instance variable 
	ComputeEngineAPI computeEngineAPI;

	public DataStoreAPI() {
		return;
	}
	
	//getter
	public List<Integer> getInputList() {
		return inputList;
	}

	//setter
	public void setInputList(List<Integer> inputList) {
		this.inputList = inputList;
	}
	
	public List<Integer> addInput(int a){
		return inputList;
	}
	
	//input response method
	public InputResponse readInput(InputRequest inputRequest) {
		return null;
	}
	
	//output response method
	public OutputResponse writeOutput(OutputRequest outputRequest) {
		return null;
	}
}

package datastoreapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataStoreAPI {

	// list where the inputs will be stored
	private List<Integer> inputList = new ArrayList<>();

	// list where the outputs will be stored
	private List<String> outputList = new ArrayList<>();

	// instance variable
	ComputeEngineAPI computeEngineAPI;
	OutputResponse outputResponse;
	InputResponse inputResponse;

	public DataStoreAPI() {
	}

	public DataStoreAPI(OutputResponse outputResponse) {
		if(outputResponse == null) {
			throw new IllegalArgumentException("OutputResponse cannot be null");
		}

		this.outputResponse = outputResponse;
	}

	public DataStoreAPI(InputResponse inputResponse) {
		if(inputResponse == null) {
			throw new IllegalArgumentException("InputResponse cannot be null");
		}
		this.inputResponse = inputResponse;
	}

	public DataStoreAPI(ComputeEngineAPI computeEngine) {
		if(computeEngine == null) {
			throw new IllegalArgumentException("ComputeEngineAPI cannot be null");
		}
		this.computeEngineAPI = computeEngine;
	}

	// getters
	public List<Integer> getInputList() {
		return inputList;
	}

	public List<String> getOutputList() {
		return outputList;
	}

	// setters
	public void setInputList(List<Integer> inputList) {
		if(inputList == null || inputList.isEmpty()) {
			throw new IllegalArgumentException("Input list cannot be null or empty");
		}
		this.inputList = inputList;
	}

	public void setOutputList(List<String> outputList){
		this.outputList = outputList;
	}

	// addInput method
	public List<Integer> addInput(int a) {
		if(a < 0) {
			throw new IllegalArgumentException("Input cannot be negative");
		}
		return inputList;
	}

	// input response method
	public List<Integer> readInput(InputRequest inputRequest) {
		if(inputRequest == null) {
			throw new IllegalArgumentException("InputRequest cannot be null");
		}
		try {
			FileReader f = new FileReader(inputRequest.getFile()); 
			Scanner in = new Scanner(f);
			while (in.hasNextLine()) {
				int input = in.nextInt();
				inputList.add(input);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return inputList;
	}

	// output response method
	public List<String> writeOutput(OutputRequest outputRequest) {
		if(outputRequest == null) {
			throw new IllegalArgumentException("OutputRequest cannot be null");
		}
		try {
			FileWriter f = new FileWriter(outputRequest.getFile());
			for (String output : outputList) {
				String finalOutput = "Output = " + output + "\n";
				f.write(finalOutput);
			}
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outputList;
	}
}


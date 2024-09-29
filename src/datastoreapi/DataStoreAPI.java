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
		return;
	}

	public DataStoreAPI(OutputResponse outputResponse) {
		this.outputResponse = outputResponse;
	}

	public DataStoreAPI(InputResponse inputResponse) {
		this.inputResponse = inputResponse;
	}

	public DataStoreAPI(ComputeEngineAPI computeEngine) {
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
		this.inputList = inputList;
	}

	public void setOutputList(List<String> outputList) {
		this.outputList = outputList;
	}

	// addInput method
	public List<Integer> addInput(int a) {
		return inputList;
	}

	// input response method
	public List<Integer> readInput(InputRequest inputRequest) {
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


package api;

public class PrototypeDataApi {
		
	public void dataSystemPrototype(DataStorageSystem data) {
		
		//read from user-specified input
		ReadInputResponse readInputResponse = data.readInput(new ReadInputRequest());
		
		//write to user-specified output
		WriteOutputResponse writeOutputResponse = data.writeOutput(new WriteOutputRequest());
		
	}

}

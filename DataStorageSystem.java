package api;

public interface DataStorageSystem {

	ReadInputResponse readInput(ReadInputRequest readInputRequest);
	
	WriteInputResponse writeInput(WriteInputRequest writeInputRequest);
	
	ReadOutputResponse readOutput(ReadOutputRequest readOutputRequest);
	
	WriteOutputResponse writeOutput(WriteOutputRequest writeOutputRequest);
}

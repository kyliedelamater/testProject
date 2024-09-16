package api;

public interface DataStorageSystem {

	ReadInputResponse readInput(ReadInputRequest readInputRequest);
	
	WriteOutputResponse writeOutput(WriteOutputRequest writeOutputRequest);
}

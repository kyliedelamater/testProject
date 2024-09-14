package api;

public interface DataStorageSystem {

	ReadInputResponse readInput(ReadInputRequest rInputRequest);
	
	WriteInputResponse writeInput(WriteInputRequest wInputRequest);
	
	ReadOutputResponse readOutput(ReadOutputRequest rOutputRequest);
	
	WriteOutputResponse writeOutput(WriteOutputRequest wOutputRequest);
}

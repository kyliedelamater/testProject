import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import datastore.Datastore.InputRequest;
import datastore.Datastore.InputResponse;
import datastore.Datastore.OutputRequest;
import datastore.Datastore.OutputResponse;
import userAPI.InMemoryDataStoreServer;
import datastore.DataStoreSystemGrpc;

public class ComputeServerAndDataServerTests {
	//blockingStub waits for a response from the server before 
	//executing the next line of code
	private DataStoreSystemGrpc.DataStoreSystemBlockingStub blockingStub;
	
	//test for readInput
	@Test
	public void testReadInput() {
		InputRequest request = InputRequest.newBuilder()
				.setFileName("input.txt").build();
		InputResponse response = blockingStub.readInput(request);
		List<Integer> inputListExpected = Arrays.asList(10, 20, 30);
		assertEquals(inputListExpected, response.getInputListList());
	}
	
	//test for writeOutput
	public void testWriteOutput() {
		OutputRequest request = OutputRequest.newBuilder()
				.setFileName("output.txt")
				.addAllOutputList(Arrays.asList(40, 50, 60))
				.build();
		OutputResponse response = blockingStub.writeOutput(request);
		assertTrue(response.getOutputWritten());
		List<Integer> outputListExpected = Arrays.asList(40, 50, 60);
		assertEquals(outputListExpected, InMemoryDataStoreServer.getInMemoryOutputList());
	}
}

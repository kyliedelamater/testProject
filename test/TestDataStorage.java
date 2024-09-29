import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import datastoreapi.ComputeEngineAPI;
import datastoreapi.DataStoreAPI;
import datastoreapi.InputRequest;
import datastoreapi.OutputRequest;
import datastoreapi.InputResponse;
import datastoreapi.OutputResponse;
import org.junit.jupiter.api.Test;

public class TestDataStorage {
	
	//test to check that the input request is valid?
	@Test
	public void testInputRequest() {
		InputRequest inputRequest = new InputRequest();
		inputRequest.checkInputResponse(inputRequest);
	}
	
	//test to check that the output request is valid?
	@Test
	public void testOutputRequest() {
		OutputRequest outputRequest = new OutputRequest();
		outputRequest.checkOutputResponse(outputRequest);
		
	}
	
	//test to check that the compute engine is passing integers
	@Test
	public void testDataStoreComputeEngine() {
		
		//mocking the interface
		ComputeEngineAPI mockComputeEngine = mock(ComputeEngineAPI.class);

		//DataStoreAPI with mockComputeEngine
		DataStoreAPI testDataStorage = new DataStoreAPI(mockComputeEngine);
	
		//testing how the compute engine adds an input to the data storage list	
		testDataStorage.addInput(1);
	}
	
	//test to check that input response works
	@Test
	public void testDataStoreInputResponse() {
		
		//mocking the interface
		InputResponse mockInputResponse = mock(InputResponse.class);

		//DataStoreAPI with mockInputResponse
		DataStoreAPI testDataStorage = mock(DataStoreAPI.class);
		
		//inputRequest object
		InputRequest inputRequest = new InputRequest();
		
		//when an input is read into the dataStorage, return input response
		when(testDataStorage.readInput(inputRequest)).thenReturn(mockInputResponse);
		
		//test that readInput works
		testDataStorage.readInput(inputRequest);		
	}
	
	//test to check that output response works
	@Test
	public void testDataStoreOutputResponse() {
		
		//mocking the interface
		OutputResponse mockOutputResponse = mock(OutputResponse.class);

		//DataStoreAPI with mockOutputResponse
		DataStoreAPI testDataStorage = mock(DataStoreAPI.class);
		
		//outputRequest object
		OutputRequest outputRequest = new OutputRequest();
		
		//when an output is written from dataStorage, return output response
		when(testDataStorage.writeOutput(outputRequest)).thenReturn(mockOutputResponse);
		
		//test that writeOutput works
		testDataStorage.writeOutput(outputRequest);
	}
}

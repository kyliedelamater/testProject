package datastoreapitests;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestDataStorage {
	
	//test to check that the input request is valid?
	@Test
	public void testInputRequest() {
		InputRequest inputRequest = new InputRequest();
		checkInputResponse(inputRequest);
	}
	
	//test to check that the output request is valid?
	@Test
	public void testOutputRequest() {
		OutputRequest outputRequest = new OutputRequest();
		checkOutputResponse(outputRequest);
		
	}
	
	//test to check that the compute engine is passing integers
	@Test
	public void testDataStoreComputeEngine() throws Exception {
		
		//mocking the interface
		ComputeEngineAPI mockComputeEngine = Mockito.mock(ComputeEngineAPI.class);
		
		//if an integer is passed from the compute engine, it is valid
		when(mockComputeEngine.validate(any(Integer.class))).thenReturn(true);
		
		//DataStoreAPI with mockComputeEngine
		DataStoreAPI testDataStorage = new DataStoreAPI(mockComputeEngine);
	
		//testing how the compute engine adds an input to the data storage list	
		testDataStorage.addInput(1);
	}
	
	//test to check that input response works
	@Test
	public void testDataStoreInputResponse() throws Exception{
		
		//mocking the interface
		InputResponse mockInputResponse = Mockito.mock(InputResponse.class);	
		
		//DataStoreAPI with mockInputResponse
		DataStoreAPI testDataStorage = new DataStoreAPI(mockInputResponse);
		
		//inputRequest object
		InputRequest inputRequest = new InputRequest();
		
		//when an input is read into the dataStorage, return input response
		when(testDataStorage.readInput(InputRequest.class).thenReturn(mockInputResponse));
		
		//test that readInput works
		testDataStorage.readInput(inputRequest);		
	}
	
	//test to check that output response works
	@Test
	public void testDataStoreOutputResponse() throws Exception{
		
		//mocking the interface
		OutputResponse mockOutputResponse = Mockito.mock(OutputResponse.class);	
		
		//DataStoreAPI with mockOutputResponse
		DataStoreAPI testDataStorage = new DataStoreAPI(mockOutputResponse);
		
		//outputRequest object
		OutputRequest outputRequest = new OutputRequest();
		
		//when an output is written from dataStorage, return output response
		when(testDataStorage.writeOutput(OutputRequest.class).thenReturn(mockOutputResponse));
		
		//test that writeOutput works
		testDataStorage.writeOutput(outputRequest);
	}
	
	
}

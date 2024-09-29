package datastoreapitests;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import datastoreapi.ComputeEngineAPI;
import datastoreapi.DataStoreAPI;
import datastoreapi.InputRequest;
import datastoreapi.InputResponse;
import datastoreapi.OutputRequest;
import datastoreapi.OutputResponse;

public class TestDataStorage {

	// test to check that the input request is valid?
	@Test
	public void testInputRequest() {
		InputRequest inputRequest = new InputRequest();
		checkInputResponse(inputRequest);
	}

	// TODO
	private void checkInputResponse(InputRequest inputRequest) {
		return;
	}

	// test to check that the output request is valid?
	@Test
	public void testOutputRequest() {
		OutputRequest outputRequest = new OutputRequest();
		checkOutputResponse(outputRequest);

	}

	// TODO
	private void checkOutputResponse(OutputRequest outputRequest) {
		return;
	}

	// test to check that the compute engine is passing integers
	@Test
	public void testDataStoreComputeEngine() throws Exception {

		// mocking the interface
		ComputeEngineAPI mockComputeEngine = Mockito.mock(ComputeEngineAPI.class);

		// if an integer is passed from the compute engine, it is valid
		when(mockComputeEngine.validate(any(Integer.class))).thenReturn(true);

		// DataStoreAPI with mockComputeEngine
		DataStoreAPI testDataStorage = new DataStoreAPI(mockComputeEngine);

		// testing how the compute engine adds an input to the data storage list
		testDataStorage.addInput(1);
	}

	// test to check that input response works
	@Test
	public void testDataStoreInputResponse() throws Exception {

		// mocking the interface
		InputResponse mockInputResponse = Mockito.mock(InputResponse.class);

		List<Integer> inputList = new ArrayList<>();

		// inputRequest object
		InputRequest inputRequest = new InputRequest("fileTest.txt");

		// when an input is read into the dataStorage, return input response
		when(mockInputResponse.readInput(inputRequest)).thenReturn(inputList);

		// DataStoreAPI with mockInputResponse
		DataStoreAPI testDataStorage = new DataStoreAPI(mockInputResponse);

		// test that readInput works
		List<Integer> testInputList = testDataStorage.readInput(inputRequest);
		
		// makes sure the test matches the inputList **not sure if this is necessary??
		assertEquals(inputList, testInputList);
	}

	// test to check that output response works
	@Test
	public void testDataStoreOutputResponse() throws Exception {

		// mocking the interface
		OutputResponse mockOutputResponse = Mockito.mock(OutputResponse.class);

		List<String> outputList = new ArrayList<>();

		// outputRequest object
		OutputRequest outputRequest = new OutputRequest("fileTest2.txt");

		// when an output is written from dataStorage, return output response
		when(mockOutputResponse.writeOutput(outputRequest)).thenReturn(outputList);

		// DataStoreAPI with mockOutputResponse
		DataStoreAPI testDataStorage = new DataStoreAPI(mockOutputResponse);

		// test that writeOutput works
		List<String> testOutputList = testDataStorage.writeOutput(outputRequest);
		
		// makes sure the test matches outputList **not sure if this is necessary??
		assertEquals(outputList, testOutputList);
	}
}

import datastoreapi.DataStoreAPI;
import interfaces.NumStream;

import java.util.ArrayList;
import java.util.List;

public class ComputeRequestHandlerImplementation implements ComputeRequestHandler {
	DataStoreAPI dataStoreAPI;
	UserRequest userRequest;

	public ComputeRequestHandlerImplementation() {
	}

	public ComputeRequestHandlerImplementation(UserRequest userRequest) {
		if(userRequest == null) {
			throw new IllegalArgumentException("UserRequest cannot be null");
		}
		this.userRequest = userRequest;
	}

	public ComputeRequestHandlerImplementation(DataStoreAPI dataStoreAPI, UserRequest userRequest) {
		if(userRequest == null) {
			throw new IllegalArgumentException("UserRequest cannot be null");
		}
		if(dataStoreAPI == null) {
			throw new IllegalArgumentException("DataStoreAPI cannot be null");
		}
		this.dataStoreAPI = dataStoreAPI;
		this.userRequest = userRequest;
	}

	@Override
	public void setUserRequest(UserRequest userRequest) {
		if(userRequest == null) {
			throw new IllegalArgumentException("UserRequest cannot be null");
		}
		this.userRequest = userRequest;
	}

	@Override
	public UserRequest getUserRequest() {
		return userRequest;
	}


	@Override
	public ResponseCode generateAndSendResponseMessage(NumStream computeResults) {
		return null;
	}

	@Override
	public <T> void setDataApi(T dataStorageApi) {
		if(dataStoreAPI == null) {
			throw new IllegalArgumentException("DataStoreAPI cannot be null");
		}
		this.dataStoreAPI = (DataStoreAPI) dataStorageApi;
	}
}



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import datastoreapi.DataStoreAPI;

public class MultiThreadedMediator extends Mediator{

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public MultiThreadedMediator(DataStoreAPI dataStoreApi, ComputeEngine computeEngine) {
        super(dataStoreApi, computeEngine);
    }

    @Override
    public <T> void sendInput(UserRequestProvider<T> provider) {
        executorService.submit(() -> {
            super.sendInput(provider);
        });
    }

}

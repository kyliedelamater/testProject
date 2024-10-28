import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadedUserIOApi extends UserIOApi{

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    public MultiThreadedUserIOApi(ComputeEngine computeEngine) {
        super(computeEngine);
    }

    public Future<EngineResponse> submitRequest(UserRequest request) {
        return executorService.submit(() -> {
            return sendRequest(request);
        });
    }

}

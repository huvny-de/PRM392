package huyvn.com.lab10.Api;

public class TraineeRepository {
    public static TraineeService getTraineeSerice(){
        return ApiClient.getClient().create(TraineeService.class);
    }
}

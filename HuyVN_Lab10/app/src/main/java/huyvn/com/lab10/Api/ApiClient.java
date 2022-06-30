package huyvn.com.lab10.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static  String baseUrl = "https://62bc1bc36b1401736cf2163b.mockapi.io/huyvn/";
    private static Retrofit retrofit;

    public  static  Retrofit getClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}

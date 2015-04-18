package soccer.sauloaguiar.soccerlist.service;

import java.util.List;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import rx.Observable;
import soccer.sauloaguiar.soccerlist.model.Tournament;

/**
 * Created by sauloaguiar on 4/17/15.
 */
public class SoccerService {

    private String endpoint = "http://sauloaguiar.koding.io:3000";
    private SoccerApi api;

    public interface SoccerApi {
        @GET("/tournaments")
        public Observable<List<Tournament>> getTournamentData();
    }

    public SoccerService(){
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        api = restAdapter.create(SoccerApi.class);
    }

    public SoccerApi getApi(){
        return api;
    }
}

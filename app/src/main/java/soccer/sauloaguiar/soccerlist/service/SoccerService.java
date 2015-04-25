package soccer.sauloaguiar.soccerlist.service;

import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import soccer.sauloaguiar.soccerlist.model.Tournament;

/**
 * Functionality: REST API Implementation using Retrofit API [http://square.github.io/retrofit/]
 * Created: 2015-04-23
 * @author: Saulo Aguiar
 */
public class SoccerService {

    private String endpoint = "http://fidel-trilogy.codio.io:3000";
    private SoccerRestAPIEndpoint api;

    public interface SoccerRestAPIEndpoint {
        @GET("/tournaments")
        public void getTournamentData(Callback<List<Tournament>> listCallback);
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
                .setLogLevel(RestAdapter.LogLevel.NONE)
                .build();

        api = restAdapter.create(SoccerRestAPIEndpoint.class);
    }

    public SoccerRestAPIEndpoint getApi(){
        return api;
    }
}

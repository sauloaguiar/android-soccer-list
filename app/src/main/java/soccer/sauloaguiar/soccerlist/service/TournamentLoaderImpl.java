package soccer.sauloaguiar.soccerlist.service;

import android.util.Log;

import org.apache.http.protocol.HTTP;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import soccer.sauloaguiar.soccerlist.model.Tournament;
import soccer.sauloaguiar.soccerlist.presenter.OnTournamentLoadedListener;

/**
 * Functionality: Contract Interface Implementation for Loading Data from Web
 * Created 2015-04-23
 * @author Saulo Aguiar
 */
public class TournamentLoaderImpl implements TournamentLoader {

    private static final String TAG = TournamentLoaderImpl.class.getName();

    @Override
    public void getTournamentsData(final OnTournamentLoadedListener callback) {
        SoccerService service = new SoccerService();
        service.getApi().getTournamentData(new Callback<List<Tournament>>() {
            @Override
            public void success(List<Tournament> tournaments, Response response) {
                callback.onTournamentDataLoaded(tournaments, response.getStatus());
                Log.i(TAG, "" + response.getStatus());
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onTournamentDataLoaded(null, 400);
                if (error != null)
                    Log.i(TAG, ""+ error.getSuccessType() + " - error!");
            }
        });
    }

}

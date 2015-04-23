package soccer.sauloaguiar.soccerlist.service;

import android.util.Log;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import soccer.sauloaguiar.soccerlist.model.Tournament;
import soccer.sauloaguiar.soccerlist.presenter.OnTournamentLoadedListener;
import soccer.sauloaguiar.soccerlist.view.TournamentView;

/**
 * Created by sauloaguiar on 4/23/15.
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
                for(Tournament t : tournaments){
                    Log.i(TAG, t.toString());
                }
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

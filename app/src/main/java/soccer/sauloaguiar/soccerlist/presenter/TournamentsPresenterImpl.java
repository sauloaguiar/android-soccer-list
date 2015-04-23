package soccer.sauloaguiar.soccerlist.presenter;

import android.util.Log;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import soccer.sauloaguiar.soccerlist.model.Tournament;
import soccer.sauloaguiar.soccerlist.service.SoccerService;
import soccer.sauloaguiar.soccerlist.service.TournamentLoader;
import soccer.sauloaguiar.soccerlist.service.TournamentLoaderImpl;
import soccer.sauloaguiar.soccerlist.view.TournamentView;

/**
 * Created by sauloaguiar on 4/23/15.
 */
public class TournamentsPresenterImpl implements TournamentsPresenter, OnTournamentLoadedListener {

    private static final String TAG = TournamentsPresenterImpl.class.getName();
    private TournamentView view;
    private TournamentLoader loader;

    public TournamentsPresenterImpl(TournamentView view){
        this.view = view;
        this.loader = new TournamentLoaderImpl();
    }

    @Override
    public void getTournamentsData() {
        loader.getTournamentsData(this);
    }

    @Override
    public void onTournamentDataLoaded(List<Tournament> data, int statusCode) {
        view.onTournamentDataLoaded(data, statusCode);
    }

}

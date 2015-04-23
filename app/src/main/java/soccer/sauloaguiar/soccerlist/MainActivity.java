package soccer.sauloaguiar.soccerlist;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import soccer.sauloaguiar.soccerlist.model.Match;
import soccer.sauloaguiar.soccerlist.model.Round;
import soccer.sauloaguiar.soccerlist.model.Tournament;
import soccer.sauloaguiar.soccerlist.presenter.TournamentsPresenter;
import soccer.sauloaguiar.soccerlist.presenter.TournamentsPresenterImpl;
import soccer.sauloaguiar.soccerlist.service.SoccerService;
import soccer.sauloaguiar.soccerlist.view.MatchAdapter;
import soccer.sauloaguiar.soccerlist.view.TournamentView;


public class MainActivity extends Activity implements TournamentView {

    private static final String TAG = MainActivity.class.getName();
    public TournamentsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupActionBar();

        presenter = new TournamentsPresenterImpl(this);
        loadTournaments();
    }

    private void loadTournaments(){
        presenter.getTournamentsData();
        /*SoccerService service = new SoccerService();
        service.getApi().getTournamentData(new Callback<List<Tournament>>() {
            @Override
            public void success(List<Tournament> tournaments, Response response) {
                Log.i(TAG, ""+response.getStatus());
                for(Tournament t : tournaments){
                    Log.i(TAG, t.toString());
                }
            }

            @Override
            public void failure(RetrofitError error) {

                if (error != null)
                    Log.i(TAG, ""+ error.getSuccessType() + " - error!");
            }
        });*/
    }

    private void setupActionBar() {
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(false);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings: return true;
            case android.R.id.home:
                Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTournamentDataLoaded(List<Tournament> data, int statusCode) {
        ArrayList<Match> list = new ArrayList<Match>();
        Tournament t = new Tournament();
        Round r = new Round();
        r.addMatch(new Match());
        r.addMatch(new Match());
        r.addMatch(new Match());
        t.addRound(r);
        List<Tournament> tournamentList = new ArrayList();
        tournamentList.add(t);
        list.add(new Match());
        list.add(new Match());
        list.add(new Match());
        MatchAdapter adp = new MatchAdapter(getApplicationContext(), tournamentList );
        //MatchAdapter adp = new MatchAdapter(getApplicationContext(), data );

        ((ListView)findViewById(R.id.listview)).setAdapter(adp);
    }
}

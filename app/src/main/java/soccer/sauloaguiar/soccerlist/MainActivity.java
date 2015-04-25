package soccer.sauloaguiar.soccerlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import soccer.sauloaguiar.soccerlist.model.ListItem;
import soccer.sauloaguiar.soccerlist.presenter.TournamentsPresenter;
import soccer.sauloaguiar.soccerlist.presenter.TournamentsPresenterImpl;
import soccer.sauloaguiar.soccerlist.view.MatchAdapter;
import soccer.sauloaguiar.soccerlist.view.TournamentView;


/**
 * functionality: Represents the main view for this application
 * created: 2015-04-17
 * @author Saulo Aguiar
 * changes:
 *      2015-03-22: Making this Activity implement the View on the MVP Pattern

 */
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
                onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTournamentDataLoaded(List<ListItem> data, int statusCode) {
        MatchAdapter adp = new MatchAdapter(getApplicationContext(), data );
        ((ListView)findViewById(R.id.listview)).setAdapter(adp);
    }

    @Override
    public void onRequestError(int errorCode) {
        ((ListView)findViewById(R.id.listview)).setEmptyView( (TextView) findViewById(android.R.id.empty));
        Toast.makeText(getApplicationContext(), "Error on request - status code: " + errorCode, Toast.LENGTH_LONG).show();
    }
}

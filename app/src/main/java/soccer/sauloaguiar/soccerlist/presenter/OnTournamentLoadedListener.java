package soccer.sauloaguiar.soccerlist.presenter;

import java.util.List;

import soccer.sauloaguiar.soccerlist.model.Tournament;

/**
 * Created by sauloaguiar on 4/23/15.
 */
public interface OnTournamentLoadedListener {
    public void onTournamentDataLoaded(List<Tournament> data, int statusCode);
}

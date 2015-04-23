package soccer.sauloaguiar.soccerlist.view;

import java.util.List;

import soccer.sauloaguiar.soccerlist.model.Tournament;

/**
 * Created by sauloaguiar on 4/23/15.
 */
public interface TournamentView {
    public void onTournamentDataLoaded(List<Tournament> data, int statusCode);
}

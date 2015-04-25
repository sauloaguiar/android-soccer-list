package soccer.sauloaguiar.soccerlist.presenter;

import java.util.List;

import soccer.sauloaguiar.soccerlist.model.Tournament;

/**
 * Functionality: Callback Interface to receive results after loading Tournaments
 * created: 2015-04-23
 * @author: Saulo Aguiar
 */
public interface OnTournamentLoadedListener {
    public void onTournamentDataLoaded(List<Tournament> data, int statusCode);
}

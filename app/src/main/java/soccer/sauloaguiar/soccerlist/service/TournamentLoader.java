package soccer.sauloaguiar.soccerlist.service;

import soccer.sauloaguiar.soccerlist.presenter.OnTournamentLoadedListener;

/**
 * Functionality: Contract Interface to Load Data
 * Created: 2015-04-23
 * @author: Saulo Aguiar
 */
public interface TournamentLoader {
    public void getTournamentsData(OnTournamentLoadedListener callback);
}

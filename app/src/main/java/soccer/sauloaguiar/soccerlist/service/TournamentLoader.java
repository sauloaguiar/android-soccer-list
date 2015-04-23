package soccer.sauloaguiar.soccerlist.service;

import soccer.sauloaguiar.soccerlist.presenter.OnTournamentLoadedListener;

/**
 * Created by sauloaguiar on 4/23/15.
 */
public interface TournamentLoader {
    public void getTournamentsData(OnTournamentLoadedListener callback);
}

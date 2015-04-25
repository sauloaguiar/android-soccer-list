package soccer.sauloaguiar.soccerlist.presenter;

import java.util.ArrayList;
import java.util.List;

import soccer.sauloaguiar.soccerlist.model.ListItem;
import soccer.sauloaguiar.soccerlist.model.Match;
import soccer.sauloaguiar.soccerlist.model.Round;
import soccer.sauloaguiar.soccerlist.model.Tournament;
import soccer.sauloaguiar.soccerlist.service.TournamentLoader;
import soccer.sauloaguiar.soccerlist.service.TournamentLoaderImpl;
import soccer.sauloaguiar.soccerlist.view.TournamentView;

/**
 * Functionality: Presenter Implementation.
 *                 Handles the REST API Result call and Delivers formatted Data to the Viewer
 * created: 2015-23-04
 * @author: Saulo Aguiar
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

        if (statusCode != 400){
            List<ListItem> items = new ArrayList<>();
            for ( Tournament tournament : data) {
                for (Round round : tournament.getRounds()){
                    for (Match match : round.getMatches()) {
                        ListItem item = new ListItem(match, round, tournament);
                        items.add(item);
                    }
                }

            }
            view.onTournamentDataLoaded(items, statusCode);
        } else {
            view.onRequestError(statusCode);
        }

    }

}

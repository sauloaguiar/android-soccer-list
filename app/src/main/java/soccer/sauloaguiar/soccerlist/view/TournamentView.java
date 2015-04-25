package soccer.sauloaguiar.soccerlist.view;

import java.util.List;

import soccer.sauloaguiar.soccerlist.model.ListItem;

/**
 * Functionality: View Interface that represents the Viewer in the MVP Pattern
 * Created 2015-04-23
 * @author Saulo Aguiar
 */
public interface TournamentView {
    public void onTournamentDataLoaded(List<ListItem> data, int statusCode);
    public void onRequestError(int errorCode);
}

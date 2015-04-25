package soccer.sauloaguiar.soccerlist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * functionality: Represents a Round on the JSON Object for Serialization
 * created: 2015-04-17
 * @author: Saulo Aguiar
 */
public class Round {

    private int number;
    private List<Match> matches;

    public Round(){
        matches = new ArrayList<>();
    }

    public void addMatch(Match match){
        matches.add(match);
    }

    public List<Match> getMatches() {
        return matches;
    }

    public int getRoundNumber() {
        return number;
    }
}

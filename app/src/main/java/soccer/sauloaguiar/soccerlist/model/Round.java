package soccer.sauloaguiar.soccerlist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sauloaguiar on 4/17/15.
 */
public class Round {
    private String name;
    private int number;
    private List<Match> matches;

    public Round(){
        matches = new ArrayList<>();
    }

    public void addMatch(Match match){
        matches.add(match);
    }
}

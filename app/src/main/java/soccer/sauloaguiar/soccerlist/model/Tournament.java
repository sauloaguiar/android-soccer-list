package soccer.sauloaguiar.soccerlist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sauloaguiar on 4/17/15.
 */
public class Tournament {
    private int key;
    private String name;
    private List<Round> rounds;

    public Tournament(){
        rounds = new ArrayList<Round>();
    }

    public void addRound(Round round){
        rounds.add(round);
    }
}


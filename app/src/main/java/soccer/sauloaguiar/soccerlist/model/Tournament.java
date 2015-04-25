package soccer.sauloaguiar.soccerlist.model;

import java.util.ArrayList;
import java.util.List;

/**
 * functionality: Represents a Tournament on the JSON Object for Serialization
 * created: 2015-05-17
 * @author: Saulo Aguiar
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

    public List<Round> getRounds() {
        return rounds;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return key;
    }
}


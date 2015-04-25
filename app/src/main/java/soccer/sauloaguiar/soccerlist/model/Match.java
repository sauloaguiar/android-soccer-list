package soccer.sauloaguiar.soccerlist.model;

import com.google.gson.annotations.SerializedName;

/**
 * functionality: Represents a Match on the JSON Object for Serialization
 * created: 2015-04-16
 * @author: Saulo Aguiar
 */
public class Match {

    @SerializedName("team1_key")
    private String team1Key;
    @SerializedName("team1_title")
    private String team1Title;
    @SerializedName("team1_code")
    private String team1Code;

    @SerializedName("team2_key")
    private String team2Key;
    @SerializedName("team2_title")
    private String team2Title;
    @SerializedName("team2_code")
    private String team2Code;

    @SerializedName("play_at")
    private long timestamp;
    private int score1;
    private int score2;

    @SerializedName("group")
    private int groupNumber;
    private int number;

    public String getTeam1Code() {
        return team1Code;
    }

    public String getTeam1Name() {
        return team1Title;
    }

    public int getTeam1Score() {
        return score1;
    }

    public String getTeam2Name() {
        return team2Title;
    }

    public String getTeam2Code() {
        return team2Code;
    }

    public int getTeam2Score() {
        return score2;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getNumber() {
        return number;
    }
}

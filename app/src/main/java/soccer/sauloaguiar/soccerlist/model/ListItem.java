package soccer.sauloaguiar.soccerlist.model;


import org.joda.time.DateTime;

/**
 * functionality: Represents a item in the Tournament List
 * created: 2015-04-24
 * @author: Saulo Aguiar
 */

public class ListItem {

    private int tournamentId;
    private String tournamentName;

    private int number;
    private String team1Key;
    private String team1Name;
    private String team1Code;
    private int team1Score;

    private String team2Key;
    private String team2Title;
    private String team2Code;
    private int team2Score;

    private long timestamp;

    private int groupNumber;
    private int matchNumber;
    private DateTime time;

    public ListItem(Match match, Round round, Tournament tournament){
        tournamentName = tournament.getName();
        tournamentId = tournament.getNumber();

        team1Name = match.getTeam1Name();
        team1Code = match.getTeam1Code();
        team1Score = match.getTeam1Score();

        team2Title = match.getTeam2Name();
        team2Code = match.getTeam2Code();
        team2Score = match.getTeam2Score();

        groupNumber = match.getGroupNumber();
        matchNumber = match.getNumber();

        timestamp = match.getTimestamp();
        time = new DateTime(1000L * timestamp);
    }



    public String getTeam1Name() {
        return team1Name;
    }

    public String getTeam1Score() {
        return Integer.toString(team1Score);
    }

    public String getTeam2Name() {
        return team2Title;
    }

    public String getTeam2Score() {
        return Integer.toString(team2Score);
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public String getTournamentMatch(){
        if (groupNumber == 0){
          return "Fecha " + matchNumber;
        } else {
            return "Group " + groupNumber + " - Fecha " + matchNumber;
        }
    }

    public String getMatchDayOfMonth(){
        return Integer.toString(time.getDayOfMonth());
    }

    public String getMatchMonth(){
        switch (time.getMonthOfYear()) {
            case 1:
                return "ENERO";
            case 2:
                return "FEBRERO";
            case 3:
                return "MARZO";
            case 4:
                return "ABRIL";
            case 5:
                return "MAYO";
            case 6:
                return "JUNIO";
            case 7:
                return "JULIO";
            case 8:
                return "AGOSTO";
            case 9:
                return "SEPTIEMBRE";
            case 10:
                return "OCTUBRE";
            case 11:
                return "NOVIEMBRE";
            case 12:
                return "DICIEMBRE";
            default: return "Error";
        }
    }

    public String getMatchYear(){
        return Integer.toString(time.getYear());
    }

    public String getMatchHour(){
        return time.getHourOfDay() + ":" + time.getMinuteOfHour() + " hrs";
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public String getTeam1Key() {
        return team1Code + ".gif";
    }

    public String getTeam2Key() {
        return team2Code + ".gif";
    }
}

package soccer.sauloaguiar.soccerlist.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import soccer.sauloaguiar.soccerlist.R;
import soccer.sauloaguiar.soccerlist.model.ListItem;
import soccer.sauloaguiar.soccerlist.utils.GifDecoder;

/**
 * Functionality: Custom Adapter array-backed implementation to List Matches by rows
 * Created: 2015-04-15
 * @author: Saulo Aguiar
 */
public class MatchAdapter extends ArrayAdapter<ListItem> {

    private final Context context;
    private final List<ListItem> itemsArrayList;

    public MatchAdapter(Context context, List<ListItem> array) {
        super(context, R.layout.match_row, array);

        this.context = context;
        this.itemsArrayList = array;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolderItem viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.match_row, parent, false);

            viewHolder = new ViewHolderItem();

            viewHolder.dateInfoLayout = (LinearLayout) convertView.findViewById(R.id.date_info_layout);

            viewHolder.team1Logo = (ImageView) convertView.findViewById(R.id.home_team_logo);
            viewHolder.team1Name = (TextView) convertView.findViewById(R.id.home_team_name);
            viewHolder.team1Score = (TextView) convertView.findViewById(R.id.home_team_score);

            viewHolder.team2Logo = (ImageView) convertView.findViewById(R.id.visitor_team_logo);
            viewHolder.team2Name = (TextView) convertView.findViewById(R.id.visitor_team_name);
            viewHolder.team2Score = (TextView) convertView.findViewById(R.id.visitor_team_score);

            viewHolder.tournamentName = (TextView) convertView.findViewById(R.id.tournament_name);
            viewHolder.tournamentMatch = (TextView) convertView.findViewById(R.id.tournament_match);

            viewHolder.matchDay = (TextView) convertView.findViewById(R.id.match_day);
            viewHolder.matchMonthText = (TextView) convertView.findViewById(R.id.match_month_text);
            viewHolder.matchYear = (TextView) convertView.findViewById(R.id.match_year);
            viewHolder.matchHour = (TextView) convertView.findViewById(R.id.match_hour);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        ListItem item = itemsArrayList.get(position);
        if (item != null){
            try {
                switch(item.getTournamentId()){
                    case 1:
                        viewHolder.dateInfoLayout.setBackgroundColor(context.getResources().getColor(R.color.green));
                        break;
                    case 2:
                        viewHolder.dateInfoLayout.setBackgroundColor(context.getResources().getColor(R.color.red));
                        break;

                }

                viewHolder.team1Logo.setImageBitmap(getBitmap(item.getTeam1Key()));
                viewHolder.team1Name.setText(item.getTeam1Name());
                viewHolder.team1Score.setText(item.getTeam1Score());

                viewHolder.team2Logo.setImageBitmap(getBitmap(item.getTeam2Key()));
                viewHolder.team2Name.setText(item.getTeam2Name());
                viewHolder.team2Score.setText(item.getTeam2Score());

                viewHolder.tournamentName.setText(item.getTournamentName());
                viewHolder.tournamentMatch.setText(item.getTournamentMatch());

                viewHolder.matchHour.setText(item.getMatchHour());
                viewHolder.matchDay.setText(item.getMatchDayOfMonth());
                viewHolder.matchMonthText.setText(item.getMatchMonth());
                viewHolder.matchYear.setText(item.getMatchYear());


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return convertView;
    }

    private Bitmap getBitmap(String gifName) throws IOException {
        GifDecoder n = new GifDecoder();
        InputStream raw = context.getAssets().open(gifName);
        n.read(raw);
        return n.getBitmap();
    }

    // our ViewHolder.
    // caches our TextView
    static class ViewHolderItem {
        LinearLayout dateInfoLayout;

        ImageView team1Logo;
        TextView team1Name;
        TextView team1Score;

        ImageView team2Logo;
        TextView team2Name;
        TextView team2Score;

        TextView tournamentName;
        TextView tournamentMatch;

        TextView matchDay;
        TextView matchMonthText;
        TextView matchYear;
        TextView matchHour;
    }
}

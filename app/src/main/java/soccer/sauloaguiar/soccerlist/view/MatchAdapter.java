package soccer.sauloaguiar.soccerlist.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import soccer.sauloaguiar.soccerlist.R;
import soccer.sauloaguiar.soccerlist.model.Match;

/**
 * Created by sauloaguiar on 4/16/15.
 */
public class MatchAdapter extends ArrayAdapter<Match> {

    private final Context context;
    private final ArrayList<Match> itemsArrayList;

    public MatchAdapter(Context context, ArrayList<Match> array) {
        super(context, R.layout.match_row, array);

        this.context = context;
        this.itemsArrayList = array;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view  = inflater.inflate(R.layout.match_row, parent, false);

        return view;
    }
}

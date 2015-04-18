package soccer.sauloaguiar.soccerlist.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import soccer.sauloaguiar.soccerlist.R;
import soccer.sauloaguiar.soccerlist.model.Match;
import soccer.sauloaguiar.soccerlist.utils.GifDecoder;

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

        ImageView homeTeam = (ImageView) view.findViewById(R.id.home_team_logo);
        ImageView visitorTeam = (ImageView) view.findViewById(R.id.visitor_team_logo);

        try {
            GifDecoder n = new GifDecoder();
            InputStream raw = context.getAssets().open("spfc.gif");
            n.read(raw);
            homeTeam.setImageBitmap(n.getBitmap());

            n = new GifDecoder();
            InputStream raw2 = context.getAssets().open("asla.gif");
            n.read(raw2);
            visitorTeam.setImageBitmap(n.getBitmap());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }

}

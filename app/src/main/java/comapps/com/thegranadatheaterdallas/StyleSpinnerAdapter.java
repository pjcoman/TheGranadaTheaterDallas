package comapps.com.thegranadatheaterdallas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by me on 8/6/2015.
 */
public class StyleSpinnerAdapter extends ArrayAdapter<CharSequence> {
    Context ctx;
    String[] styleitems;
    LayoutInflater mInflater;
    int selecteditem = -1;


    public StyleSpinnerAdapter(Context context, int resource, String[] styles) {
        super(context, resource, styles);
        ctx = context;
        styleitems = styles;

        mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
    }



    public View getDropDownView(int position, View convertView, ViewGroup parent)  {

        return getStyleDropDownView(position, convertView, parent);



    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return getStyleView(position, convertView, parent);
    }

    public View getStyleView(int position, View convertView, ViewGroup parent) {
        View row = mInflater.inflate(R.layout.simple_dropdown_item_1line, parent, false);
        TextView style = (TextView) row.findViewById(android.R.id.text1);
        style.setTypeface(Typeface.createFromAsset(ctx.getAssets(), "fonts/MAFW.TTF"));

        return row;


    }

    private View getStyleDropDownView(final int position, View convertView, ViewGroup parent) {
        View row = mInflater.inflate(R.layout.simple_dropdown_item_1line, parent, false);
        TextView style = (TextView) row.findViewById(android.R.id.text1);
        style.setTypeface(Typeface.createFromAsset(ctx.getAssets(), "fonts/MAFW.TTF"));

        return row;
    }

}

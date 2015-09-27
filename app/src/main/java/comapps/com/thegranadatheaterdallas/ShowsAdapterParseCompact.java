package comapps.com.thegranadatheaterdallas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by me on 4/28/2015.
 */
class ShowsAdapterParseCompact extends BaseAdapter {

    public static final String LOGTAG="THEGRANADATHEATER";

    private final Context context;
    private final ArrayList<Shows> showsList;
    private final LayoutInflater inflater;
    private List<Shows> list = null;
    // private ViewHolder holder;








    public ShowsAdapterParseCompact(Context context, List<Shows> list) {

        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.showsList = new ArrayList<Shows>();
        this.showsList.addAll(list);





    }

    private Context getContext() {
        return context;
    }




    public class ViewHolder {
        public ImageView imageview;
        public ImageView ticketsimageview;
        public TextView bandName;
        public TextView actStyle;
        public TextView bandNotes;

        public TextView ticketPrice;
        public TextView showDate;
        public TextView showTime;
        public TextView otherActs;
        public TextView whereFrom;
        public TextView otherInfo;






    }

    @Override
    public int getCount()  { return list.size(); }
    @Override
    public Object getItem( int position ) { return list.get(position); }
    @Override
    public long getItemId( int position ) { return  position; }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        final ViewHolder holder;




        if (view == null) {


            holder = new ViewHolder();
            view = inflater.inflate(R.layout.showsrowcompact, null);
            holder.imageview = (ImageView) view.findViewById(R.id.bandImage);
            holder.ticketsimageview = (ImageView) view.findViewById(R.id.buyTickets);
            holder.bandName = (TextView) view.findViewById(R.id.bandName);
            holder.actStyle = (TextView) view.findViewById(R.id.musicType);
            holder.bandNotes = (TextView) view.findViewById(R.id.bandNotes);
            holder.ticketPrice = (TextView) view.findViewById(R.id.ticketPrice);
            holder.showDate = (TextView) view.findViewById(R.id.showDate);
            holder.showTime = (TextView) view.findViewById(R.id.showTime);
            holder.otherActs = (TextView) view.findViewById(R.id.otherActs);
            holder.whereFrom = (TextView) view.findViewById(R.id.bandWhereFrom);
            holder.otherInfo = (TextView) view.findViewById(R.id.otherInfo);



            view.setTag(holder);


        } else {

            holder = (ViewHolder) view.getTag();
        }



        // String url = showsList.get(position).getActImageLink();
        // Picasso.with(getContext()).load(url).into(holder.imageview);

        Picasso.with(context).load(showsList.get(position).getActImageLink()).into(holder.imageview);
       // Picasso.with(context).load(showsList.get(position).getTicketsImage()).into(holder.ticketsimageview);




        holder.bandName.setText(showsList.get(position).getActName());
        holder.actStyle.setText(showsList.get(position).getActStyle());
        holder.bandNotes.setText(showsList.get(position).getActDescription());
        holder.ticketPrice.setText(showsList.get(position).getPrice());
        holder.showDate.setText(showsList.get(position).getShowDate());
        holder.showTime.setText(showsList.get(position).getShowTime());
        holder.otherActs.setText(showsList.get(position).getOtherActs());
        holder.whereFrom.setText(showsList.get(position).getWhereFrom());
        holder.otherInfo.setText(showsList.get(position).getOtherInfo());

        String price = showsList.get(position).getPrice();

        switch(price) {

            case "FREE":
                holder.ticketsimageview.setImageResource(R.drawable.buytickets_soldout); break;
            case "SOLD OUT":
                holder.ticketsimageview.setImageResource(R.drawable.buytickets_soldout); break;
            default:
                holder.ticketsimageview.setImageResource(R.drawable.buyticketsbutton);

        }



        final String showLink = showsList.get(position).getShowLink();

        holder.ticketsimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Intent intentBuyTickets = new Intent(context, BuyTicketsWebView.class);
                    intentBuyTickets.putExtra("showlink", showLink);




                    context.startActivity(intentBuyTickets);

                    ((Activity) context).overridePendingTransition(R.anim.fadeinanimationlong, R.anim.fadeoutanimation);





                } catch (Exception e) {

                    Log.e("Show cell undefined", e.toString());

                }

            }
        });


        return view;

    }






}

package comapps.com.thegranadatheaterdallas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by me on 3/4/2015.
 */
class ShowsAdapterParse extends BaseAdapter {

    private static final String LOGTAG = "THEGRANADATHEATER";


    private final Context context;
    private final ArrayList<Shows> showsList;
    private final LayoutInflater inflater;
    private List<Shows> list = null;

    // private ViewHolder holder;


    public ShowsAdapterParse(Context context, List<Shows> list) {

        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        this.showsList = new ArrayList<>();
        this.showsList.addAll(list);


    }



    public class ViewHolder {

        public ImageView imageview;
        public ImageView imageview2;
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
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        final ViewHolder holder;
        //   final ViewFlipper flippy;


        if (view == null) {


            holder = new ViewHolder();
            view = inflater.inflate(R.layout.showsrow, null);
            holder.imageview = (ImageView) view.findViewById(R.id.bandImage);
            holder.imageview2 = (ImageView) view.findViewById(R.id.imageViewOtherActs);
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


        Transformation transformation = new RoundedTransformationBuilder()
                .borderColor(Color.TRANSPARENT)
                .borderWidthDp(3)
                .cornerRadiusDp(10)
                .oval(false)
                .build();


        Picasso.with(context).load(showsList.get(position).getActImageLink()).fit().transform(transformation).into(holder.imageview);

        holder.bandName.setText(showsList.get(position).getActName());
        holder.actStyle.setText(showsList.get(position).getActStyle());
        holder.bandNotes.setText(showsList.get(position).getActDescription());
        holder.ticketPrice.setText(showsList.get(position).getPrice());
        holder.showDate.setText(showsList.get(position).getShowDate());
        holder.showTime.setText(showsList.get(position).getShowTime());
        holder.otherActs.setText(showsList.get(position).getOtherActs());
        holder.whereFrom.setText(showsList.get(position).getWhereFrom());
        holder.otherInfo.setText(showsList.get(position).getOtherInfo());


        if (showsList.get(position).getActImageLink2() == null) {

            holder.imageview2.setVisibility(View.GONE);
            holder.otherActs.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);


        } else {

            holder.imageview2.setVisibility(View.VISIBLE);
            holder.otherActs.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
            Picasso.with(context).load(showsList.get(position).getActImageLink2()).fit().transform(transformation).into(holder.imageview2);
            //  Picasso.with(context).load(showsList.get(position).getTicketsImage()).into(holder.ticketsimageview);


        }


        switch (showsList.get(position).getPrice()) {

            case "FREE":

             //   Log.i(LOGTAG, "inside the switch statement FREE");

                holder.ticketsimageview.setImageResource(R.drawable.buytickets_soldout);
                break;
            case "SOLD OUT":
                holder.ticketsimageview.setImageResource(R.drawable.buytickets_soldout);
                break;
            case "?":
                holder.ticketsimageview.setImageResource(R.drawable.buytickets_soldout);
                break;


            default:
                holder.ticketsimageview.setImageResource(R.drawable.buyticketsbutton);

             //   Log.i(LOGTAG, "inside the switch statement default");

        }

        if (showsList.get(position).getPrice() == null) {
            holder.ticketsimageview.setImageResource(R.drawable.buytickets_soldout);
        }

        final String showLink = showsList.get(position).getShowLink();

        holder.ticketsimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (showLink != null && !showLink.isEmpty()) {

                    Intent intentBuyTickets = new Intent(context, BuyTicketsWebView.class);
                    intentBuyTickets.putExtra("showlink", showLink);
                    context.startActivity(intentBuyTickets);
                    ((Activity) context).overridePendingTransition(R.anim.fadeinanimationlong, R.anim.fadeoutanimation);


                } else {

                    Log.v(LOGTAG, "Show cell undefined");

                }

            }
        });

        return view;

    }


}


package comapps.com.thegranadatheaterdallas;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ShowsActivityParse extends AppCompatActivity {

    private static final String LOGTAG="THEGRANADATHEATER";
    private static final String VIEWIMAGE="pref_viewimages";
    private static final String LIST_POSITION ="listPosition";

    private int savedPosition = 0;



    private SharedPreferences settings;
 //   private SharedPreferences.OnSharedPreferenceChangeListener listener;

    // Declare Variables
    private ListView listview;
    private ArrayList<String> actStylesFromParse = new ArrayList<String>();





    ProgressDialog mProgressDialog;

    private ShowsAdapterParseCompact adaptercompact;

    private List<Shows> showsList = null;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MAFW.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        setContentView(R.layout.showslist);

        final Spinner actStyleDropDown = (Spinner) findViewById(R.id.styleSpinner);

    //    final String[] actStyles = {"All", "NEW", "50\'s", "60\'s", "70\'s", "80\'s",
    //            "Acoustic", "Alt-Country", "Alternative", "Americana", "Benefit", "Bluegrass", "Blues",
    //            "Comedy", "Country", "Folk", "Funk", "Gospel", "Indie", "Industrial", "Jazz", "Metal",
    //            "Movie", "Pop", "Punk", "Rock", "Ska", "Soul", "Sports", "Tribute"};

        actStylesFromParse.add(" All");
        actStylesFromParse.add(" NEW");

        ParseQuery<ParseObject> query = new ParseQuery<>(
                "GranadaShows").fromLocalDatastore();

        Date today = new Date();
        query.orderByAscending("showdate").whereGreaterThanOrEqualTo("showdate", today);

        try {
            List<ParseObject> ob = query.find();

            for(ParseObject show : ob){
                Log.d("TAG", "styles: " + show.getString("actstyle"));
                String tempStyles = show.getString("actstyle");
                String tempStylesSplit[] = tempStyles.split(",");

                int x;

                for ( x = 0; x<tempStylesSplit.length; x++) {
                    String tempStylesSplitClean = tempStylesSplit[x].trim();

                    if (actStylesFromParse.contains(tempStylesSplitClean)) {

                        Log.d("TAG", "did not add: " + tempStylesSplitClean);

                    } else {



                        actStylesFromParse.add(tempStylesSplitClean);
                    }


                    Log.d("TAG", "styles Array: " + actStylesFromParse);

                }
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<String> actStylesFromParseList = actStylesFromParse;

        Collections.sort(actStylesFromParseList, new Comparator<String>() {
            public int compare(String obj1, String obj2) {
                // TODO Auto-generated method stub
                return obj1.compareToIgnoreCase(obj2);
            }
        });

        String[] actStyles = actStylesFromParseList.toArray(new String[actStylesFromParse.size()]);

        actStyles[0] = actStyles[0].trim();
        actStyles[1] = actStyles[1].trim();







        query = new ParseQuery<>("GranadaShows").fromLocalDatastore();



        query.orderByAscending("showdate").whereGreaterThanOrEqualTo("showdate", today);

        try {
            int x = query.count();

            actStyles[0] = actStyles[0] + " (" + String.valueOf(x) + ")";
            Log.i("Number of shows ", String.valueOf(x));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //   query.orderByDescending("createdAt").setLimit(10).whereGreaterThanOrEqualTo("showdate", today);


        Date twoWeeksAgo = new DateTime(today).minusWeeks(2).toDate();

        query.orderByDescending("createdAt").whereGreaterThanOrEqualTo("createdAt", twoWeeksAgo);

        try {
            int x = query.count();
            actStyles[1] = actStyles[1] + " (" + String.valueOf(x) + ")";
            Log.i("Number of new shows ", String.valueOf(x));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        query = new ParseQuery<>("GranadaShows").fromLocalDatastore();

        int i;

        for (i = 2; i < actStyles.length; i++) {

            query.orderByAscending("showdate").whereGreaterThanOrEqualTo("showdate", today);
            query.whereContains("actstyle", actStyles[i]);
            try {
                int x = query.count();
                Log.i("Number of shows ", String.valueOf(x));

                if (x != 0) {

                    actStyles[i] = actStyles[i] + " (" + String.valueOf(x) + ")";
                } else {

                    actStyles[i] = null  ;

                }

            } catch (ParseException e) {
                e.printStackTrace();
            }




        }

        int newSize = 0;
        for (int j = 0; j < actStyles.length; j++)  {

            if (actStyles[j] != null)  {
                newSize++;
            }

        }

        String[] actStylesClean = new String[newSize];
        int newIndex = 0;
        for (int k = 0; k < actStyles.length; k++)  {
            if (actStyles[k] != null)  {
                actStylesClean[newIndex] = actStyles[k];
                newIndex++;
            }

        }

        settings = PreferenceManager.getDefaultSharedPreferences(this);






    /*    SharedPreferences prefs = this.getSharedPreferences(
                "comapps.com.thegranadatheaterdallas", Context.MODE_PRIVATE);
        boolean hasVisited = prefs.getBoolean("HAS_VISISTED_BEFORE", false);
        if(!hasVisited) {


            prefs.edit().putBoolean("HAS_VISISTED_BEFORE", true).commit();  */

        //   new RemoteDataTask().execute();


        ArrayAdapter<String> styleAdapter = new ArrayAdapter<String>(this, R.layout.simple_dropdown_item_1line, actStylesClean);
        //   ArrayAdapter<CharSequence> styleAdapter = ArrayAdapter.createFromResource(this, R.array.actstyles, R.layout.simple_dropdown_item_1line);


        styleAdapter.setDropDownViewResource(R.layout.simple_dropdown_item_1line);
        actStyleDropDown.setAdapter(styleAdapter);




            actStyleDropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {




                    String spinnerActStyle = parent.getItemAtPosition(position).toString();
                    String[] spinnerActStyleSend = spinnerActStyle.split(" ");


                    spinnerActStyleSend[0].trim();


                    Log.i("Spinner selection is ", spinnerActStyleSend[0]);

                    new RemoteDataTask().execute(spinnerActStyleSend[0]);

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {


                    String spinnerActStyleSend = "All";

                    new RemoteDataTask().execute(spinnerActStyleSend);

                }
            });








        }






    @Override




    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_show, menu);

        return true;


    }




    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
               
        }






        return super.onOptionsItemSelected(item);






    }







    private void refreshDisplay() {


            boolean viewImages = settings.getBoolean(VIEWIMAGE, false);

        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("viewImages", viewImages);
        editor.apply();


            if (viewImages) {
                adaptercompact = new ShowsAdapterParseCompact(this, showsList);
                // Binds the Adapter to the ListView
                listview.setAdapter(adaptercompact);

                listview.invalidateViews();


                listview.setSelection(savedPosition);

                Log.i(LOGTAG, "Hide images checked");

            } else {

                ShowsAdapterParse adapter = new ShowsAdapterParse(this, showsList);
                // Binds the Adapter to the ListView
                listview.setAdapter(adapter);

                listview.invalidateViews();

                listview.setSelection(savedPosition);

                Log.i(LOGTAG, "Hide images unchecked");

            }




    }




    private class RemoteDataTask extends AsyncTask<String, Void, Void> {




        @Override
        protected Void doInBackground(String... params) {

            String actStyleFilter = params[0];
            Log.i("Act style filter is ", actStyleFilter);

            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            showsList = new ArrayList<>();


            try {


                // Locate the class table named "stansdata" in Parse.com
                ParseQuery<ParseObject> query = new ParseQuery<>(
                        "GranadaShows").fromLocalDatastore();


                Date today = new Date();


                Log.i("today is ", today.toString());

                // by ascending

                if ("All".equals(actStyleFilter)) {

                    query.orderByAscending("showdate").whereGreaterThanOrEqualTo("showdate", today);


                } else if ("NEW".equals(actStyleFilter)) {

                    Date twoWeeksAgo = new DateTime(today).minusWeeks(2).toDate();
                    query.whereGreaterThanOrEqualTo("showdate", today);
                    query.orderByDescending("createdAt").whereGreaterThanOrEqualTo("createdAt", twoWeeksAgo);



                } else {

                    query.orderByAscending("showdate").whereGreaterThanOrEqualTo("showdate", today);
                    query.whereContains("actstyle", actStyleFilter);

                }


                List<ParseObject> showobject = query.find();

             //   ParseObject.pinAllInBackground(showobject);

                for (ParseObject parseclass : showobject) {
                    // Locate images in flag column
                    ParseFile image = (ParseFile) parseclass.get("ticketsimage");
                    //   ParseFile actimage = (ParseFile) parseclass.get("actimagefile");

                    Date showDate = (Date) parseclass.get("showdate");


                 //   Log.i("show date is ", showDate.toString());

                    Shows show = new Shows();
                    show.setActName((String) parseclass.get("actname"));
                    show.setShowDate((String) parseclass.get("showdatestring"));
                    show.setShowTime((String) parseclass.get("doors"));
                    show.setPrice((String) parseclass.get("price"));
                    show.setActImageLink((String) parseclass.get("actimage"));
                    show.setActImageLink2((String) parseclass.get("actimage2"));
                    show.setShowLink((String) parseclass.get("ticketslink"));
                    show.setWhereFrom((String) parseclass.get("actfrom"));
                    show.setOtherActs((String) parseclass.get("otheracts"));
                    show.setActStyle((String) parseclass.get("actstyle"));
                    show.setActDescription((String) parseclass.get("description"));


                    showsList.add(show);


                }
            } catch (com.parse.ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }


            return null;
        }


        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in listview_main.xml
            listview = (ListView) findViewById(R.id.list);
            // Pass the results into ParseListViewAdapter.java
            //adapter = new ShowsAdapterParse(ShowsActivityParse.this,
            //        showsList);


            // Binds the Adapter to the ListView
            //listview.setAdapter(adapter);
            // Close the progressdialog
            // mProgressDialog.dismiss();
            // Capture button clicks on ListView items


            for(Shows show : showsList) {
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

                System.out.println(show.getActName());
                System.out.println(show.getShowDate());
                System.out.println(show.getShowTime());
                System.out.println(show.getActImageLink());
                System.out.println(show.getActImageLink2());
                System.out.println(show.getActStyle());
                System.out.println(show.getOtherActs());
                System.out.println(show.getPrice());
                System.out.println(show.getShowLink());
                System.out.println(show.getWhereFrom());








            }



            refreshDisplay();


     /*       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // Send single item click data to SingleItemView Class

                    //    if (Uri.parse(showsList.get(position).getShowLink()).toString().length() != 0) {


                }
            });

            */


        }




    }






    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        int currentPosition = listview.getFirstVisiblePosition();
        savedInstanceState.putInt(LIST_POSITION, currentPosition);

        Log.i("current position is ", String.valueOf(currentPosition));



        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);



        savedPosition = savedInstanceState.getInt(LIST_POSITION);

        Log.i("saved position is ", String.valueOf(savedPosition));


    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }





    @Override
    public void onBackPressed() {



        Intent switchactivities = new Intent();
        switchactivities.setClass(this, MainActivity.class);
        startActivity(switchactivities);
        overridePendingTransition(R.anim.fadeinanimation, R.anim.fadeoutanimation);
        finish();

    }
}

package comapps.com.thegranadatheaterdallas;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivity extends AppCompatActivity {

    public static final String LOGTAG="THEGRANADATHEATER";
    private static final String PREFERENCES = "preferencesfile";
    private SharedPreferences sharedPreferences;
    boolean checkBoxPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MAFW.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());




        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);




        setContentView(R.layout.activty_main);

        sharedPreferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);

        CheckBox checkBoxPreferences = (CheckBox) findViewById(R.id.checkBoxPreferences);





           if ( sharedPreferences == null ) {

               Log.i(LOGTAG, "sharedPreferences is null");

               checkBoxPreferences.setChecked(false);

           } else {

               checkBoxPref = sharedPreferences.getBoolean("checkboxnone", false);

               if (!checkBoxPref) {

                   checkBoxPreferences.setChecked(true);

                   Log.i("!checkBoxPref: ", String.valueOf(checkBoxPref));

               } else {

                   checkBoxPreferences.setChecked(false);

                   Log.i("else checkBoxPref: ", String.valueOf(checkBoxPref));
               }

           }

        }









            @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;


    }






   public boolean onOptionsItemSelected(MenuItem item) {
       // Handle action bar item clicks here. The action bar will
       // automatically handle clicks on the Home/Up button, so long
       // as you specify a parent activity in AndroidManifest.xml.
       int id = item.getItemId();

       if (id == R.id.notifacation_settings) {
           Intent intent = new Intent(this, NotifacationActivity.class);
           startActivity(intent);
       }

       if (id == R.id.login_settings) {
           Intent intent = new Intent(this, SignUpActivity.class);
           startActivity(intent);
       }







       return super.onOptionsItemSelected(item);
   }






    public void preferencesMainScreen (View view) {
        Intent intent = new Intent(this, NotifacationActivity.class);
        startActivity(intent);
        finish();

    }


    public void call(View view) {

        // TODO Auto-generated method stub

        Intent callIntent = new Intent(Intent.ACTION_VIEW);
        callIntent.setData(Uri.parse("tel:2148249933"));
        startActivity(callIntent);


    }


    public void map(View view) {

        // TODO Auto-generated method stub

        Intent intent5 = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps/place/Granada+Theater/@32.830888,-96.770005,17z"));
        intent5.setComponent(new ComponentName("com.google.android.apps.maps",
                "com.google.android.maps.MapsActivity"));
        startActivity(intent5);

    }





    public void upcoming_shows_granada(View view) {
        Intent intent4 = new Intent();
        intent4.setClass(this, ShowsActivityParse.class);
      //  intent4.setClass(this, ShowsFragment.class);
        overridePendingTransition(R.anim.fadeoutanimation,
                R.anim.fadeinanimation);
        startActivity(intent4);
        finish();

    }

    public void blog(View view) {
        Intent intent3 = new Intent();
        intent3.setClass(this, Blog.class);
        overridePendingTransition(R.anim.fadeoutanimation,
                R.anim.fadeinanimation);
        startActivity(intent3);
        finish();
      /*
        Intent intent3 = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.granadatheater.com/blog"));
        */
        startActivity(intent3);
    }


    public void about(View view) {
        Intent intent2 = new Intent();
        intent2.setClass(this, AboutGranada.class);
        overridePendingTransition(R.anim.fadeoutanimation,
                R.anim.fadeinanimation);
        startActivity(intent2);
        finish();
    }



    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }




    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }


}


package comapps.com.thegranadatheaterdallas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ViewFlipper;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class AboutGranada extends AppCompatActivity {

 //   private ActionBar actionBar;
    private ViewFlipper flippy;


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
               .setDefaultFontPath("fonts/MAFW.TTF")
               .setFontAttrId(R.attr.fontPath)
               .build());

        setContentView(R.layout.activity_about_granada);

       getSupportActionBar().setDisplayShowHomeEnabled(true);
       getSupportActionBar().setIcon(R.drawable.ic_launcher);



        flippy = (ViewFlipper) findViewById(R.id.viewFlipper1);
        flippy.setFlipInterval(1000);
        flippy.startFlipping();

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
    //    overridePendingTransition(R.anim.fadeinanimation, R.anim.fadeoutanimation);
        finish();

    }


}
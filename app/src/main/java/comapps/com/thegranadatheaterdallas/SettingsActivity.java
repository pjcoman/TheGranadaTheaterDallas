package comapps.com.thegranadatheaterdallas;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by me on 4/28/2015.
 */
@SuppressWarnings("deprecation")

public class SettingsActivity extends PreferenceActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

    }

    @Override
    public void onBackPressed() {



        Intent switchactivities = new Intent();
        switchactivities.setClass(this, ShowsActivityParse.class);
        startActivity(switchactivities);
     //   overridePendingTransition(R.anim.fadeinanimation, R.anim.fadeoutanimation);
        finish();

    }
}
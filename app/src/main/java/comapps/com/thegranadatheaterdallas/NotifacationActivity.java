package comapps.com.thegranadatheaterdallas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.parse.ParseInstallation;
import com.parse.ParsePush;

import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * Created by me on 7/3/2015.
 */
public class NotifacationActivity extends AppCompatActivity {

    private static final String LOGTAG = "THEGRANADATHEATER";
    private static final String PREFERENCES = "preferencesfile";

    public Context context;



    private CheckBox checkboxall, checkboxnone, checkboxindie, checkboxrock, checkboxcountry, checkboxjazzblues, checkboxfunk,
            checkboxsoul, checkboxalternative, checkboxtribute, checkboxmovie, checkboxsports, checkboxcomedy,
            checkboxacoustic, checkboxindustrial, checkboxmetal;

    private SharedPreferences sharedPreferences;









    private Button buttonset;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MAFW.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());

        setContentView(R.layout.notifacationsettings);





        buttonset = (Button) findViewById(R.id.buttonSet);


        sharedPreferences = getSharedPreferences(PREFERENCES, MODE_PRIVATE);

        addListenerOnButton();
        addListenerToCheckBoxAll();
        addListenerToCheckBoxNone();
        addListenerToCheckBoxIndie();
        addListenerToCheckBoxRock();
        addListenerToCheckBoxCountry();
        addListenerToCheckBoxJazz();
        addListenerToCheckBoxFunk();
        addListenerToCheckBoxSoul();
        addListenerToCheckBoxAlternative();
        addListenerToCheckBoxTribute();
        addListenerToCheckBoxMovie();
        addListenerToCheckBoxSports();
        addListenerToCheckBoxComedy();
        addListenerToCheckBoxAcoustic();
        addListenerToCheckBoxIndustrial();
        addListenerToCheckBoxMetal();


    }

    private void addListenerToCheckBoxAll() {
        CheckBox checkboxall = (CheckBox) findViewById(R.id.checkBoxAll);
        checkboxall.setChecked(sharedPreferences.getBoolean("checkboxall", false));
        checkboxall.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked()) {
                            checkboxnone.setChecked(false);
                            checkboxindie.setChecked(true);
                            checkboxrock.setChecked(true);
                            checkboxcountry.setChecked(true);
                            checkboxjazzblues.setChecked(true);
                            checkboxfunk.setChecked(true);
                            checkboxsoul.setChecked(true);
                            checkboxalternative.setChecked(true);
                            checkboxtribute.setChecked(true);
                            checkboxmovie.setChecked(true);
                            checkboxsports.setChecked(true);
                            checkboxcomedy.setChecked(true);
                            checkboxacoustic.setChecked(true);
                            checkboxindustrial.setChecked(true);
                            checkboxmetal.setChecked(true);


                        }
                    }
                }
        );

    }

    private void addListenerToCheckBoxNone() {
        checkboxnone = (CheckBox) findViewById(R.id.checkBoxNone);
        checkboxnone.setChecked(sharedPreferences.getBoolean("checkboxnone", true));
        checkboxnone.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox)v).isChecked()) {
                            checkboxall.setChecked(false);
                            checkboxnone.setChecked(true);
                            checkboxindie.setChecked(false);
                            checkboxrock.setChecked(false);
                            checkboxcountry.setChecked(false);
                            checkboxjazzblues.setChecked(false);
                            checkboxfunk.setChecked(false);
                            checkboxsoul.setChecked(false);
                            checkboxalternative.setChecked(false);
                            checkboxtribute.setChecked(false);
                            checkboxmovie.setChecked(false);
                            checkboxsports.setChecked(false);
                            checkboxcomedy.setChecked(false);
                            checkboxacoustic.setChecked(false);
                            checkboxindustrial.setChecked(false);
                            checkboxmetal.setChecked(false);

                            checkboxindie.setVisibility(View.VISIBLE);
                            checkboxrock.setVisibility(View.VISIBLE);
                            checkboxcountry.setVisibility(View.VISIBLE);
                            checkboxjazzblues.setVisibility(View.VISIBLE);
                            checkboxfunk.setVisibility(View.VISIBLE);
                            checkboxsoul.setVisibility(View.VISIBLE);
                            checkboxalternative.setVisibility(View.VISIBLE);
                            checkboxtribute.setVisibility(View.VISIBLE);
                            checkboxmovie.setVisibility(View.VISIBLE);
                            checkboxsports.setVisibility(View.VISIBLE);
                            checkboxcomedy.setVisibility(View.VISIBLE);
                            checkboxacoustic.setVisibility(View.VISIBLE);
                            checkboxindustrial.setVisibility(View.VISIBLE);
                            checkboxmetal.setVisibility(View.VISIBLE);
                        }
                    }
                }
        );

    }

    private void addListenerToCheckBoxIndie() {
        checkboxindie = (CheckBox) findViewById(R.id.checkBoxIndie);
        checkboxindie.setChecked(sharedPreferences.getBoolean("checkboxindie", false));
        checkboxindie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox)v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }

    private void addListenerToCheckBoxRock() {
        checkboxrock = (CheckBox) findViewById(R.id.checkBoxRock);
        checkboxrock.setChecked(sharedPreferences.getBoolean("checkboxrock", false));
        checkboxrock.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox)v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }
    private void addListenerToCheckBoxCountry() {
        checkboxcountry = (CheckBox) findViewById(R.id.checkBoxCountry);
        checkboxcountry.setChecked(sharedPreferences.getBoolean("checkboxcountry", false));
        checkboxcountry.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox)v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }
    private void addListenerToCheckBoxJazz() {
        checkboxjazzblues = (CheckBox) findViewById(R.id.checkBoxJazzBlues);
        checkboxjazzblues.setChecked(sharedPreferences.getBoolean("checkboxjazzblues", false));
        checkboxjazzblues.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox)v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }
    private void addListenerToCheckBoxFunk() {
        checkboxfunk = (CheckBox) findViewById(R.id.checkBoxFunk);
        checkboxfunk.setChecked(sharedPreferences.getBoolean("checkboxfunk", false));
        checkboxfunk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox)v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }
    private void addListenerToCheckBoxSoul() {
        checkboxsoul = (CheckBox) findViewById(R.id.checkBoxSoul);
        checkboxsoul.setChecked(sharedPreferences.getBoolean("checkboxsoul", false));
        checkboxsoul.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox)v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }
    private void addListenerToCheckBoxAlternative() {
        checkboxalternative = (CheckBox) findViewById(R.id.checkBoxAlternative);
        checkboxalternative.setChecked(sharedPreferences.getBoolean("checkboxalternative", false));
        checkboxalternative.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox)v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }
    private void addListenerToCheckBoxTribute() {
        checkboxtribute = (CheckBox) findViewById(R.id.checkBoxTribute);
        checkboxtribute.setChecked(sharedPreferences.getBoolean("checkboxtribute", false));
        checkboxtribute.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }
    private void addListenerToCheckBoxMovie() {
        checkboxmovie = (CheckBox) findViewById(R.id.checkBoxMovie);
        checkboxmovie.setChecked(sharedPreferences.getBoolean("checkboxmovie", false));
        checkboxmovie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox)v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }
    private void addListenerToCheckBoxSports() {
        checkboxsports = (CheckBox) findViewById(R.id.checkBoxSports);
        checkboxsports.setChecked(sharedPreferences.getBoolean("checkboxsports", false));
        checkboxsports.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox)v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }
    private void addListenerToCheckBoxComedy() {
        checkboxcomedy = (CheckBox) findViewById(R.id.checkBoxComedy);
        checkboxcomedy.setChecked(sharedPreferences.getBoolean("checkboxcomedy", false));
        checkboxcomedy.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox)v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }
    private void addListenerToCheckBoxAcoustic() {
        checkboxacoustic = (CheckBox) findViewById(R.id.checkBoxAcoustic);
        checkboxacoustic.setChecked(sharedPreferences.getBoolean("checkboxacoustic", false));
        checkboxacoustic.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );
    }

    private void addListenerToCheckBoxIndustrial() {
        checkboxindustrial = (CheckBox) findViewById(R.id.checkBoxIndustrial);
        checkboxindustrial.setChecked(sharedPreferences.getBoolean("checkboxindustrial", false));
        checkboxindustrial.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );
    }

    private void addListenerToCheckBoxMetal() {
        checkboxmetal = (CheckBox) findViewById(R.id.checkBoxMetal);
        checkboxmetal.setChecked(sharedPreferences.getBoolean("checkboxmetal", false));
        checkboxmetal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((CheckBox) v).isChecked()) {
                            checkboxnone.setChecked(false);

                        }
                        if (!((CheckBox) v).isChecked()) {
                            checkboxall.setChecked(false);

                        }
                    }
                }
        );

    }


    private void addListenerOnButton() {
        checkboxall = (CheckBox) findViewById(R.id.checkBoxAll);
        checkboxnone = (CheckBox) findViewById(R.id.checkBoxNone);
        checkboxindie = (CheckBox) findViewById(R.id.checkBoxIndie);
        checkboxrock = (CheckBox) findViewById(R.id.checkBoxRock);
        checkboxcountry = (CheckBox) findViewById(R.id.checkBoxCountry);
        checkboxjazzblues = (CheckBox) findViewById(R.id.checkBoxJazzBlues);
        checkboxfunk = (CheckBox) findViewById(R.id.checkBoxFunk);
        checkboxsoul = (CheckBox) findViewById(R.id.checkBoxSoul);
        checkboxalternative = (CheckBox) findViewById(R.id.checkBoxAlternative);
        checkboxtribute = (CheckBox) findViewById(R.id.checkBoxTribute);
        checkboxmovie = (CheckBox) findViewById(R.id.checkBoxMovie);
        checkboxsports = (CheckBox) findViewById(R.id.checkBoxSports);
        checkboxcomedy = (CheckBox) findViewById(R.id.checkBoxComedy);
        checkboxacoustic = (CheckBox) findViewById(R.id.checkBoxAcoustic);
        checkboxindustrial = (CheckBox) findViewById(R.id.checkBoxIndustrial);
        checkboxmetal = (CheckBox) findViewById(R.id.checkBoxMetal);






        buttonset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(NotifacationActivity.this, "All :" + checkboxall.isChecked() + "\nNone :" + checkboxnone.isChecked() + "\nIndie :" + checkboxindie.isChecked() + "\nRock :" + checkboxrock.isChecked() + "\nCountry :" + checkboxcountry.isChecked() + "\nJazz:" + checkboxjazzblues.isChecked() + "\nFunk :" + checkboxfunk.isChecked() + "\nSoul :" + checkboxsoul.isChecked() + "\nAlternative :" + checkboxalternative.isChecked() + "\nCover :" + checkboxtribute.isChecked() + "\nMovie :" + checkboxmovie.isChecked() + "\nSports :" + checkboxsports.isChecked() + "\nComedy :" + checkboxcomedy.isChecked() + "\nAcoustic :" + checkboxacoustic.isChecked() + "\nIndustrial :" + checkboxindustrial.isChecked() + "\nMetal :" + checkboxmetal.isChecked(), Toast.LENGTH_LONG).show();

                ParseInstallation currentInstall = ParseInstallation.getCurrentInstallation();

                try {
                    List<String> subscribedChannels = currentInstall.getList("channels");
                    String subscribedChannelsString = subscribedChannels.toString();
                    String subscribedChannelsString_nobrackets = subscribedChannelsString.replaceAll("\\[|\\]", "");
                    String subscribedChannelsString_nobrackets_nospaces = subscribedChannelsString_nobrackets.replaceAll(" ", "");
                    Log.d("list", subscribedChannelsString_nobrackets_nospaces);
                    String[] subscribedChannelsArray = subscribedChannelsString_nobrackets_nospaces.split(",");
                    int numberOfChannels = subscribedChannelsArray.length;
                    Log.d("# in list", String.valueOf(numberOfChannels));


                    for (int x = 0; x < (numberOfChannels); x++) {
                        Log.d("x = ", String.valueOf(x));
                        Log.d("channel removed is ", subscribedChannelsArray[x]);
                        ParsePush.unsubscribeInBackground(subscribedChannelsArray[x]);
                        Log.d("x = ", String.valueOf(x));

                        SystemClock.sleep(1000);


                    }

                    currentInstall.saveInBackground();


                    List<String> subscribedChannels_POSTLOOP = currentInstall.getList("channels");
                    String subscribedChannelsString_POSTLOOP = subscribedChannels_POSTLOOP.toString();
                    String subscribedChannelsString_nobrackets_POSTLOOP = subscribedChannelsString_POSTLOOP.replaceAll("\\[|\\]", "");
                    Log.d("list", subscribedChannelsString_nobrackets_POSTLOOP);

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(LOGTAG, "null set / initial run");
                }


                if (checkboxall.isChecked()) {
                    ParsePush.subscribeInBackground("ALL");

                }

                if (checkboxnone.isChecked())  {
                    ParsePush.subscribeInBackground("XXXXXX");

                }

                if ((checkboxindie.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("INDIE");

                }

                if ((checkboxrock.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("ROCK");

                }

                if ((checkboxcountry.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("COUNTRY");

                }

                if ((checkboxjazzblues.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("JAZZ");

                }

                if ((checkboxfunk.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("FUNK");

                }

                if ((checkboxsoul.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("SOUL");
                }

                if ((checkboxalternative.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("ALTERNATIVE");

                }

                if ((checkboxtribute.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("TRIBUTE");

                }

                if ((checkboxmovie.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("MOVIE");

                }

                if ((checkboxsports.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("SPORTS");

                }

                if ((checkboxcomedy.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("COMEDY");

                }

                if ((checkboxacoustic.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("ACOUSTIC");

                }

                if ((checkboxindustrial.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("INDUSTRIAL");

                }

                if ((checkboxmetal.isChecked()) && (!checkboxall.isChecked())) {
                    ParsePush.subscribeInBackground("METAL");

                }

                List<String> subscribedChannels_DONE = currentInstall.getList("channels");
                String subscribedChannelsString_DONE = subscribedChannels_DONE.toString();
                String subscribedChannelsString_nobrackets_DONE = subscribedChannelsString_DONE.replaceAll("\\[|\\]", "");
                Log.d("list", subscribedChannelsString_nobrackets_DONE);

                currentInstall.saveInBackground();


                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("checkboxall", checkboxall.isChecked());
                editor.putBoolean("checkboxnone", checkboxnone.isChecked());
                editor.putBoolean("checkboxindie", checkboxindie.isChecked());
                editor.putBoolean("checkboxrock", checkboxrock.isChecked());
                editor.putBoolean("checkboxcountry", checkboxcountry.isChecked());
                editor.putBoolean("checkboxjazzblues", checkboxjazzblues.isChecked());
                editor.putBoolean("checkboxfunk", checkboxfunk.isChecked());
                editor.putBoolean("checkboxsoul", checkboxsoul.isChecked());
                editor.putBoolean("checkboxalternative", checkboxalternative.isChecked());
                editor.putBoolean("checkboxtribute", checkboxtribute.isChecked());
                editor.putBoolean("checkboxmovie", checkboxmovie.isChecked());
                editor.putBoolean("checkboxsports", checkboxsports.isChecked());
                editor.putBoolean("checkboxcomedy", checkboxcomedy.isChecked());
                editor.putBoolean("checkboxacoustic", checkboxacoustic.isChecked());
                editor.putBoolean("checkboxindustrial", checkboxindustrial.isChecked());
                editor.putBoolean("checkboxmetal", checkboxmetal.isChecked());

                editor.apply();

                Intent returnToMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(returnToMain);


                finish();








            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }




}

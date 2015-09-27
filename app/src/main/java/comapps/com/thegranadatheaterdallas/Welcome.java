package comapps.com.thegranadatheaterdallas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

/**
 * Created by me on 7/2/2015.
 */
public class Welcome extends Activity {

    // Declare Variable
    private Button logout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.welcome);




        // Retrieve current user from Parse.com
        ParseUser currentUser = ParseUser.getCurrentUser();

        // Convert currentUser into String
        String struser = currentUser.getUsername().toString();




        ParseInstallation currentInstall = ParseInstallation.getCurrentInstallation();
        currentInstall.put("username", currentUser.getUsername().toString());
        currentInstall.put("User", ParseUser.getCurrentUser());
     //   currentInstall.put("email", currentUser.getEmail().toString());

        try {
            currentInstall.save();
        } catch (ParseException e) {
            e.printStackTrace();
        }




        // Locate TextView in welcome.xml
        TextView txtuser = (TextView) findViewById(R.id.txtuser);

        // Set the currentUser String into TextView
        txtuser.setText("You are logged in as " + struser);

        // Locate Button in welcome.xml
        logout = (Button) findViewById(R.id.logout);

        // Logout Button Click Listener
        logout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // Logout current user
                ParseUser.logOut();
                finish();
            }
        });
    }
}

package comapps.com.thegranadatheaterdallas;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by me on 3/4/2015.
 */
public class ParseApplication extends Application {

    private static final String LOGTAG = "TGTPARSEAPPLICATION";


    public void onCreate() {
        super.onCreate();


        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Parse Keys from ParseKeys class

        Parse.initialize(this, ParseKeys.applicationId, ParseKeys.clientKey);




        ParseInstallation.getCurrentInstallation().saveInBackground();



        ParseUser.enableAutomaticUser();
        ParseUser.getCurrentUser().saveInBackground();
        ParseACL defaultACL = new ParseACL();


        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);

        ParseQuery<ParseObject> query = new ParseQuery<>(
                "GranadaShows");

        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(final List<ParseObject> shows, ParseException e) {
                // Remove the previously cached results.
                ParseObject.unpinAllInBackground("GranadaShows", new DeleteCallback() {
                    public void done(ParseException e) {
                        // Cache the new results.
                        ParseObject.pinAllInBackground("GranadaShows", shows);

                        Log.i(LOGTAG, "Granada shows pinned");

                    }
                });
            }
        });


        saveParseGeoPointBackground();


    }


    private void saveParseGeoPointBackground() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy hh.mm.ss.S aa");
        SimpleDateFormat dateFormatAMPM = new SimpleDateFormat("aa");
        String formattedDate = dateFormatAMPM.format(new Date()).toString();
        System.out.println(formattedDate);

        Log.i("AM or PM?", formattedDate);

        if (formattedDate.contentEquals("PM"))  {

            Log.i("AM or PM? inside loop", formattedDate);

            LocationManager manager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
            LocationListener listener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {

                    ParseGeoPoint userLocation = new ParseGeoPoint(location.getLatitude(), location.getLongitude());

                    ParseInstallation currentInstallation = ParseInstallation.getCurrentInstallation();

                    ParseGeoPoint userGeoPoint = new ParseGeoPoint(userLocation.getLatitude(), userLocation.getLongitude());

                    double granadaLat = 32.830849;
                    double granadaLong = -96.7698177;
                    ParseGeoPoint granadaGeoPoint = new ParseGeoPoint(granadaLat, granadaLong);

                    double distanceToUser = granadaGeoPoint.distanceInMilesTo(userGeoPoint);
                    int intDistance = (int) distanceToUser + 1;

                    String distanceToTheater = String.format("distance to theater is %.2f miles ", distanceToUser);
                    Log.i(LOGTAG, distanceToTheater);
                    Log.i("distance to theater is ", String.valueOf(intDistance));

                    currentInstallation.put("userLocation", userGeoPoint);
                    currentInstallation.put("actualDistanceInMilesFromTheater", distanceToTheater);
                    currentInstallation.put("lessThanNumberOfMilesFromTheater", intDistance);

                    currentInstallation.saveInBackground(new SaveCallback() {

                        @Override
                        public void done(ParseException exception) {
                            if (exception != null) {
                                Log.e(LOGTAG, exception.getCause() + exception.getMessage());
                            }
                        }
                    });

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };

            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);


        } else {

            Log.i("no update of location", formattedDate);



        }

    }


}


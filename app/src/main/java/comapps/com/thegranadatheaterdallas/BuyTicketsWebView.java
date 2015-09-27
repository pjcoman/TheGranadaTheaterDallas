package comapps.com.thegranadatheaterdallas;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class BuyTicketsWebView extends AppCompatActivity {
    private WebView webView;

    private static final String LOGTAG="THEGRANADATHEATER";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webviewbuytickets);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MAFW.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build());



        Bundle extras = getIntent().getExtras();

        String ticketsLink = extras.getString("showlink");

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        webView = (WebView) findViewById(R.id.webview1);
        webView.setWebViewClient(new MyWebViewClient());



        String url = ticketsLink;

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);




    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {


            view.loadUrl(url);

            return true;
        }
    }







    public void close(View v) {


        finish();

    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));

    }
}

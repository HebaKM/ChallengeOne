package com.example.hebam.challengeone;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);


        if ( isNetworkAvailable() ) //check if internet available or not
        {
            //Shows a toast with the status of the Internet connection
            Toast.makeText(
                    ActivityB.this,
                    "Internet Connected",
                    Toast.LENGTH_LONG
            ).show();
            //Shows the about page of the Andela website in the webView
            WebView webview = (WebView)findViewById(R.id.webview);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.clearCache(true);
            webview.getSettings().setDomStorageEnabled(true);

            webview.setWebViewClient(new WebViewClient() {
                @Override
                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    handler.proceed();
                }
            });

            webview.loadUrl("https://andela.com/alc");
        }
        else //Not connected
        {
            //Shows a toast with the status of the Internet connection
            Toast.makeText(
                    ActivityB.this,
                    "Internet Disconnected",
                    Toast.LENGTH_LONG
            ).show();
        }
    }
    /**
     * Gets the current status of the Internet connection
     * @return boolean a value indicating the status of the Internet connection
     */
    public boolean isNetworkAvailable()
    {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}

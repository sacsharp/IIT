package com.gfc.iit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class WebviewQuizActivity extends AppCompatActivity {

    Drawable d;
    TextView textView;
    WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_quiz);


        final String mimeType = "text/html";
        final String encoding = "UTF-8";


        String url = "http://img.diytrade.com/smimg/624823/8393129-4212304-0/Superbright_Led_Modules_LM_W6_40X40_4P_12V/5f59.jpg";
//        ImageLoader imageLoader = ImageLoader.getInstance();
//        imageLoader.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));
////        imageLoader.loadImage(url, new SimpleImageLoadingListener() {
////            @Override
////            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
////                // Do whatever you want with Bitmap
////                bmp = loadedImage;
////            }
////        });
//        bmp = imageLoader.loadImageSync(url);

//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);
//
//        URL newurl = null;
//        try {
//            newurl = new URL(url);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        try {
//            bmp = BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            // get input stream
            InputStream ims = getAssets().open("min.jpeg");
            // load image as Drawable
            d = Drawable.createFromStream(ims, null);
        }
        catch(IOException ex) {
            return;
        }

       // RadioButton mRadioButton = (RadioButton) findViewById(R.id.rb1);
//        final String path = "min.jpeg";
//        mRadioButton.setText(Html.fromHtml("Hello <img src='#' /> World <img src='#'/>" , new Html.ImageGetter() {
//            @Override
//            public Drawable getDrawable(String source) {
//                try {
//                    d = Drawable.createFromStream(getApplicationContext().getAssets().open(path), null);
//                    d.setBounds(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return  d;
//            }
//        }, null));
        String html = "Hello " +
                "<img src='min.jpeg'/>" +
                " This is a test " +
                "<img src='mine.jpg'/>";

        mWebView = (WebView) findViewById(R.id.web_view);
        mWebView.loadDataWithBaseURL("file:///android_asset/",html,"text/html","UTF-8",null);



    }


}


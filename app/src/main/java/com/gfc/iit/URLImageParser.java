package com.gfc.iit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.Html;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

/**
 * Created by Sachin on 11/24/2015.
 */
public class URLImageParser implements Html.ImageGetter {
    Context c;
    View container;
    Drawable d;
    /***
     * Construct the URLImageParser which will execute AsyncTask and refresh the container
     * @param t
     * @param c
     */
    public URLImageParser(View t, Context c) {
        this.c = c;
        this.container = t;
    }

    public Drawable getDrawable(String source) {

        try {
                   d = Drawable.createFromStream(c.getAssets().open(source), null);
                    d.setBounds(0,0,d.getIntrinsicWidth(),d.getIntrinsicHeight());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return  d;
    }

}

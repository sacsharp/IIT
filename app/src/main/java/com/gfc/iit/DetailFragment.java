package com.gfc.iit;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

/**
 * Created by Sachin on 11/10/2015.
 */
public class DetailFragment extends Fragment{
    TextView text;
    public DetailFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile_detail, container, false);
        ImageButton imageView = (ImageButton) rootView.findViewById(R.id.profileImage);
        imageView.setImageResource(R.drawable.ic_perm_identity_white_48dp);

        TextView textView1 = (TextView) rootView.findViewById(R.id.userName);
        TextView textView2 = (TextView) rootView.findViewById(R.id.standard);

        textView1.setText("Student XYZ");
        textView2.setText("7");



        return rootView;
    }
}

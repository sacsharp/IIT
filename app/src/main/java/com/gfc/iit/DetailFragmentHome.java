package com.gfc.iit;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.util.LayoutDirection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Sachin on 11/17/2015.
 */
public class DetailFragmentHome extends Fragment {

    public DetailFragmentHome () {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        StudentsDBAdapter databaseHelper = new StudentsDBAdapter(getActivity());
        List<Student> studentList = databaseHelper.getAllStudents();
        String name="";
        Integer standard=0;

        LinearLayout ll = new LinearLayout(getActivity());
        ll.setOrientation(LinearLayout.VERTICAL);

        for(Student student : studentList)
        {
             name = student.get_name();
            standard = student.get_standard();

            CardView card = new CardView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,300
            );
            int margin = 20;
            params.setMargins(margin, margin , margin, margin);
            card.setLayoutParams(params);
            card.setCardBackgroundColor(Color.BLACK);
            card.setRadius(4);
            card.setMaxCardElevation(4);

            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(R.drawable.ic_face_white_48dp);
            linearLayout.addView(imageView);
            imageView.setLayoutParams(params1);

            params1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            TextView textView = new TextView(getActivity());
            textView.setText(name+" "+standard);
            textView.setTextColor(Color.RED);
            textView.setTextSize(50);
            linearLayout.addView(textView);
            textView.setLayoutParams(params1);

            card.addView(linearLayout);
            ll.addView(card);
        }

        View view = ll;

        return view;
    }
}

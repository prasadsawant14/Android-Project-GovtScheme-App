package com.example.prasadsawant.govtscheme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * Created by prasad sawant on 14-04-2017.
 */

public class TrendingList extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trending_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_about1);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        TextView textView =(TextView)findViewById(R.id.textView9);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='www.digitalindia.gov.in/'> www.digitalindia.gov.in/</a>";
        textView.setText(Html.fromHtml(text));

        TextView textView1 =(TextView)findViewById(R.id.textView16);
        textView1.setClickable(true);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());
        String text1 = "<a href='https://www.pmjdy.gov.in/scheme'>https://www.pmjdy.gov.in/scheme</a>";
        textView1.setText(Html.fromHtml(text1));

        TextView textView2 =(TextView)findViewById(R.id.textView8);
        textView2.setClickable(true);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        String text2 = "<a href='/www.swachhbharaturban.in/ '> www.swachhbharaturban.in/</a>";
        textView2.setText(Html.fromHtml(text2));

        TextView textView3 =(TextView)findViewById(R.id.textView21);
        textView3.setClickable(true);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
        String text3 = "<a href='www.makeinindia.com/home'> www.makeinindia.com/home</a>";
        textView3.setText(Html.fromHtml(text3));

        TextView textView4 =(TextView)findViewById(R.id.textView19);
        textView4.setClickable(true);
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
        String text4 = "<a href='saanjhi.gov.in/'> saanjhi.gov.in//a>";
        textView4.setText(Html.fromHtml(text4));





    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    }


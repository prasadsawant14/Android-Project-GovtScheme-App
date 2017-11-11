package com.example.prasadsawant.govtscheme;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import static com.example.prasadsawant.govtscheme.R.id.textView3;
import static com.example.prasadsawant.govtscheme.R.id.textView3nationalmission;
import static com.example.prasadsawant.govtscheme.R.id.tv1;
import static com.example.prasadsawant.govtscheme.R.id.tv1nationalmission;

/**
 * Created by prasad sawant on 14-04-2017.
 */

public class tempFarmer4 extends AppCompatActivity{
    TextView tv;
    TextView tv11;
    Firebase fb;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_click_nationalmission);

        Firebase.setAndroidContext(this);
        tv = (TextView)findViewById(textView3nationalmission);
        tv11 = (TextView)findViewById(tv1nationalmission);


        ///////////////
        tv11.setClickable(true);
        tv11.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "<a href='http://nmsa.dac.gov.in/'>read more...</a>";
        tv11.setText(Html.fromHtml(text));
////////////////////////////////////////////


        fb = new Firebase("https://fireapp-1a94d.firebaseio.com/FamrmerContent/farmer1");
//        Firebase fb1 = fb.child("url");
        Firebase fb_content = fb.child("content5");
        fb_content.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue().toString();
                tv.setText(value);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
                tv.setMovementMethod(new ScrollingMovementMethod());







    }


}

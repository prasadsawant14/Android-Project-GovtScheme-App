package mFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.prasadsawant.govtscheme.R;
import com.example.prasadsawant.govtscheme.temp;
import com.example.prasadsawant.govtscheme.tempFarmer1;
import com.example.prasadsawant.govtscheme.tempFarmer2;
import com.example.prasadsawant.govtscheme.tempFarmer3;
import com.example.prasadsawant.govtscheme.tempFarmer4;
import com.example.prasadsawant.govtscheme.tempStudent1;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import mData.ShowData;

import static com.example.prasadsawant.govtscheme.R.id.imageInModel;
import static com.example.prasadsawant.govtscheme.R.id.textInModel;

/**
 * Created by prasad sawant on 14-04-2017.
 */

public class Students extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FirebaseApp.initializeApp(getContext());
        View rootView = inflater.inflate(R.layout.students,container,false);
        ListView lv = (ListView) rootView.findViewById(R.id.studentsList);
//        ListView1.CustomAdapter adapterStudent = new ListView1.CustomAdapter(this.getActivity(),getStudent());
//        lv.setAdapter(adapterStudent);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent();
                if(position == 0){
                    intent1.setClass(getContext(),tempStudent1.class);
                    startActivity(intent1);
                }
                if(position == 1){
                    intent1.setClass(getContext(),temp.class);
                    startActivity(intent1);
                }
                if(position == 2){
                    intent1.setClass(getContext(),temp.class);
                    startActivity(intent1);
                }
                if(position == 3){
                    intent1.setClass(getContext(),temp.class);
                    startActivity(intent1);
                }
                if(position == 4){
                    intent1.setClass(getContext(),temp.class);
                    startActivity(intent1);
                }



            }
        });


        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fireapp-1a94d.firebaseio.com/studentSchemesTitles");
        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(getActivity(),
                String.class, R.layout.list_model, databaseReference) {

            @Override
            protected void populateView(View v, String model, int position) {

                TextView tv = (TextView)v.findViewById(textInModel);
                tv.setText(model);

                ImageView img =(ImageView)v.findViewById(imageInModel);
                if(position == 0){
                    img.setImageResource(R.drawable.student1);
                }
                if(position == 1){
                    img.setImageResource(R.drawable.student2);
                }
                if(position == 2){
                    img.setImageResource(R.drawable.student3);
                }
                if(position == 3){
                    img.setImageResource(R.drawable.student4);
                }
                if(position == 4){
                    img.setImageResource(R.drawable.student5);
                }

            }

        };
        lv.setAdapter(firebaseListAdapter);

        return rootView;
    }





//    private ArrayList<ShowData> getStudent(){
//
//        ArrayList<ShowData> student =new ArrayList<>();
//        ShowData data1 = new ShowData("Prasad",R.drawable.dalailama);
//        student.add(data1);
//
//        data1 = new ShowData("Avaneesh",R.drawable.news1);
//        student.add(data1);
//
//        data1 = new ShowData("Sunil",R.drawable.news2);
//        student.add(data1);
//
//        return student;
//
//    }

    @Override
    public String toString() {
        return "student";
    }

}

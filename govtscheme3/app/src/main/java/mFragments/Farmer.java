package mFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.prasadsawant.govtscheme.Main3Activity;
import com.example.prasadsawant.govtscheme.MainActivity;
import com.example.prasadsawant.govtscheme.R;
import com.example.prasadsawant.govtscheme.temp;
import com.example.prasadsawant.govtscheme.tempFarmer1;
import com.example.prasadsawant.govtscheme.tempFarmer2;
import com.example.prasadsawant.govtscheme.tempFarmer3;
import com.example.prasadsawant.govtscheme.tempFarmer4;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import mData.ShowData;

import static android.support.constraint.R.id.parent;
import static com.example.prasadsawant.govtscheme.R.id.imageInModel;
import static com.example.prasadsawant.govtscheme.R.id.textInModel;

/**
 * Created by prasad sawant on 14-04-2017.
 */

public class Farmer extends Fragment {

//    final static String urlAddress = "http://127.0.0.1/webapp/farmerData.php";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        FirebaseApp.initializeApp(getContext());
        View rootView = inflater.inflate(R.layout.farmers,container,false);
       ListView  lv = (ListView) rootView.findViewById(R.id.farmerList);
//        FloatingActionButton floatingActionButton =(FloatingActionButton)rootView.findViewById(R.id.fab);

//        final String urlAddress = "http://127.0.0.1/webapp/farmerData.php";
//        ListView1.CustomFarmerAdapter adapterFarmer = new ListView1.CustomFarmerAdapter(this.getActivity(),getFarmers());
//        lv.setAdapter(adapterFarmer);

//        new Downloader(getContext(),urlAddress,lv).execute();


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent();
                if(position == 0){
                    intent1.setClass(getContext(),temp.class);
                    startActivity(intent1);
                }
                if(position == 1){
                    intent1.setClass(getContext(),tempFarmer1.class);
                    startActivity(intent1);
                }
                if(position == 2){
                    intent1.setClass(getContext(),tempFarmer2.class);
                    startActivity(intent1);
                }
                if(position == 3){
                    intent1.setClass(getContext(),tempFarmer3.class);
                    startActivity(intent1);
                }
                if(position == 4){
                    intent1.setClass(getContext(),tempFarmer4.class);
                    startActivity(intent1);
                }



            }
        });



//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Downloader(getContext(),urlAddress,lv).execute();
//            }
//        });

        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fireapp-1a94d.firebaseio.com/farmerSchemesTitles");
        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(getActivity(),
                String.class, R.layout.list_model, databaseReference) {

//            StorageReference storageRef = storage.getReference();

            StorageReference httpsReference = FirebaseStorage.getInstance().getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/fireapp-1a94d.appspot.com/o/images.jpg?alt=media&token=0f5457a5-5a17-44e1-93bf-ae940d9c8830");



            @Override
            protected void populateView(View v, String model, int position) {

                TextView tv = (TextView)v.findViewById(textInModel);
                tv.setText(model);

                ImageView img =(ImageView)v.findViewById(imageInModel);
                if(position == 0){
                    img.setImageResource(R.drawable.farmer1);
                }
                if(position == 1){
                    img.setImageResource(R.drawable.farmer2);
                }
                if(position == 2){
                    img.setImageResource(R.drawable.farmer3);
                }
                if(position == 3){
                    img.setImageResource(R.drawable.farmer4);
                }
                if(position == 4){
                    img.setImageResource(R.drawable.farmer5);
                }

               //Glide.with(getActivity()).using(new FirebaseImageLoader()).load(httpsReference).override(130, 130).into(img);



            }

        };


        lv.setAdapter(firebaseListAdapter);


        return rootView;
    }




//    private ArrayList<ShowData> getFarmers(){
//
//        ArrayList<ShowData> farmers =new ArrayList<>();
//        ShowData data1 = new ShowData("Prasad",R.drawable.dalailama);
//        farmers.add(data1);
//
//        data1 = new ShowData("Avaneesh",R.drawable.news1);
//        farmers.add(data1);
//
//        data1 = new ShowData("Sunil",R.drawable.news2);
//        farmers.add(data1);
//
//        data1 = new ShowData("Sunil",R.drawable.news2);
//        farmers.add(data1);
//        data1 = new ShowData("Sunil",R.drawable.news2);
//        farmers.add(data1);
//        data1 = new ShowData("Sunil",R.drawable.news2);
//        farmers.add(data1);
//        data1 = new ShowData("Sunil",R.drawable.news2);
//        farmers.add(data1);
//        data1 = new ShowData("Sunil",R.drawable.news2);
//        farmers.add(data1);
//        data1 = new ShowData("Sunil",R.drawable.news2);
//        farmers.add(data1);
//        data1 = new ShowData("Sunil",R.drawable.news2);
//        farmers.add(data1);
//
//
//        return farmers;
//
//    }

    @Override
    public String toString() {

        String title = "Farmers";
        return title;
    }
}




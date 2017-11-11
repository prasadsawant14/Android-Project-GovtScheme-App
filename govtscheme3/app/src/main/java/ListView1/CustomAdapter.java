package ListView1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prasadsawant.govtscheme.R;

import java.util.ArrayList;

import mData.ShowData;



/**
 * Created by prasad sawant on 14-04-2017.
 */

public class CustomAdapter extends BaseAdapter {
     Context c;
    ArrayList<ShowData> showData;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<ShowData> showData) {
        this.c = c;
        this.showData = showData;
    }

    @Override
    public int getCount() {
        return showData.size();
    }

    @Override
    public Object getItem(int position) {
        return showData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(inflater == null){
            inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_model,parent,false);

        }

        TextView nameTxt =(TextView)convertView.findViewById(R.id.textInModel);
        ImageView imgSrc =(ImageView)convertView.findViewById(R.id.imageInModel);


        final String name = showData.get(position).getData();
        int image = showData.get(position).getIamge();

        nameTxt.setText(name);
        imgSrc.setImageResource(image);

//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(c,name,Toast.LENGTH_SHORT).show();
//            }
//        });

        return convertView;
    }
}

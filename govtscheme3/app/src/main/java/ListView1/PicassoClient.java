package ListView1;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.ImageView;

import com.example.prasadsawant.govtscheme.R;
import com.squareup.picasso.Picasso;

/**
 * Created by prasad sawant on 23-04-2017.
 */

public class PicassoClient {

    public  static  void  downloadImage(Context c, String imageUrl, ImageView img){

        if(imageUrl.length() > 0 && imageUrl != null){

            Picasso.with(c).load(imageUrl).placeholder(R.drawable.placeholder).into(img);

        }else{
            Picasso.with(c).load(R.drawable.placeholder).into(img);
        }

    }
}

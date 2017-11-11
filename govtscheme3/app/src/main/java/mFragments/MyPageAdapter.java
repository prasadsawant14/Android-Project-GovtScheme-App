package mFragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by prasad sawant on 14-04-2017.
 */

public class MyPageAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> pages = new ArrayList<>();

    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    ////////////////////
    public void addFragment(Fragment f){
        pages.add(f);
    }
    ///////////////


    @Override
    public CharSequence getPageTitle(int position) {
        String title = pages.get(position).toString();
        return title.toString();
    }
}

package skyfree.com.phonexlaunche;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by dinhtuanthanh on 21/03/2018.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        return Fragment_1.newInstance(pos+1);
    }

    @Override
    public int getCount() {
        return 5;
    }
}
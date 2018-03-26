package skyfree.com.phonexlaunche;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends FragmentActivity {
//    private ViewPager viewPager;
//    GridView gridView_item;
//    List<AppModel> mCityList;
//    GridViewCustomAdapter gridadapter;

//
//        RecyclerView recyclerView;
//        AppsAdapter adapter;
//        RecyclerView.LayoutManager recyclerViewLayoutManager;
    RecyclerView recyclerView;
    AppsAdapter adapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    List<String> list1;
    List<String> list2;
    List<String> list3;
    List<String> listPakage;
    ApkInfoExtractor apkInfoExtractor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        listPakage = new ArrayList<>();
        apkInfoExtractor = new ApkInfoExtractor(this);
        listPakage = apkInfoExtractor.GetAllInstalledApkInfo();

        for (int i = 0;i<4;i ++){
                    list1.add(listPakage.get(i));
                }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerviewbottom);
        recyclerView.getBackground().setAlpha(80);
        recyclerViewLayoutManager = new GridLayoutManager(this, 4);
        // Passing the column number 1 to show online one column in each row.
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        adapter = new AppsAdapter(this,list1);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        pager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        indicator.setViewPager(pager);

//
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//
//        // Passing the column number 1 to show online one column in each row.
//        recyclerViewLayoutManager = new GridLayoutManager(MainActivity.this, 4);
//
//        recyclerView.setLayoutManager(recyclerViewLayoutManager);
//
//        adapter = new AppsAdapter(MainActivity.this, new ApkInfoExtractor(MainActivity.this).GetAllInstalledApkInfo());
//
//        recyclerView.setAdapter(adapter);



//        gridView_item = (GridView) findViewById(R.id.grid_view_custom);
//        createData();
//        gridadapter = new GridViewCustomAdapter(MainActivity.this,mCityList,0);
//        gridView_item.setAdapter(gridadapter);
////        viewPager = (ViewPager) findViewById(R.id.viewpager);
////        Adapter_ViewPagerFragment adapter_viewPagerFragment =new Adapter_ViewPagerFragment(getSupportFragmentManager(),3);
////        viewPager.setAdapter(adapter_viewPagerFragment);
    }
//    public void createData(){
//        mCityList = new ArrayList<>();
//        mCityList.add(new AppModel("Hà Nội", R.drawable.ic_launcher));
//        mCityList.add(new AppModel("Hồ Chí Minh", R.drawable.ic_launcher));
//        mCityList.add(new AppModel("Hải Phòng", R.drawable.ic_launcher));
//        mCityList.add(new AppModel("Đà Nẵng", R.drawable.ic_launcher));
//        mCityList.add(new AppModel("Hà Giang", R.drawable.ic_launcher));
//        mCityList.add(new AppModel("Hải Dương", R.drawable.ic_launcher));
//        mCityList.add(new AppModel("Hưng Yên", R.drawable.ic_launcher));
//    }
}
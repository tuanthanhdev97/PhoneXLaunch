package skyfree.com.phonexlaunche;

import android.app.WallpaperManager;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class ChangeWallpaperActivity extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout setBtn,skipbtn;
    ArrayList<Integer> imagelist;
    WallpaperManager wallpaperManager;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_wallpaper);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        setBtn = (LinearLayout) findViewById(R.id.setBtn);
        skipbtn = (LinearLayout) findViewById(R.id.skipBtn);
        wallpaperManager = WallpaperManager.getInstance(ChangeWallpaperActivity.this);
        prepareData();
        viewPager.setCurrentItem(imagelist.get(0));
        WallpaperAdapter adapter = new WallpaperAdapter(imagelist, ChangeWallpaperActivity.this);
        viewPager.setAdapter(adapter);

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = viewPager.getCurrentItem();

                try {
                    wallpaperManager.setResource(imagelist.get(position));
                    Intent intent = new Intent(ChangeWallpaperActivity.this,MainActivity.class);
                    startActivity(intent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeWallpaperActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public void prepareData() {
        imagelist = new ArrayList<>();
        imagelist.add(R.drawable.background1);
        imagelist.add(R.drawable.backgroung2);
        imagelist.add(R.drawable.backgroung3);
        imagelist.add(R.drawable.backgroung4);
        imagelist.add(R.drawable.backgroung5);
        imagelist.add(R.drawable.backgroung6);
        imagelist.add(R.drawable.backgroung7);
        imagelist.add(R.drawable.backgroung8);
        imagelist.add(R.drawable.backgroung9);
    }

}

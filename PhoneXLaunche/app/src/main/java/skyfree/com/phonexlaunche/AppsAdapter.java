package skyfree.com.phonexlaunche;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static skyfree.com.phonexlaunche.R.*;

/**
 * Created by dinhtuanthanh on 21/03/2018.
 */

class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.ViewHolder>{

    Context context1;
    List<String> stringList ;



    public AppsAdapter(Context context, List<String> list){
        context1 = context;
        stringList=list;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public LinearLayout cardView;
        public ImageView imageView;
        public TextView textView_App_Name;

        public ViewHolder (View view){

            super(view);

            cardView = (LinearLayout) view.findViewById(id.card_view);
            cardView.setBackgroundColor(Color.TRANSPARENT);
            imageView = (ImageView) view.findViewById(id.imageview);
            textView_App_Name = (TextView) view.findViewById(id.Apk_Name);

        }
    }

    @Override
    public AppsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view2 = LayoutInflater.from(context1).inflate(layout.list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view2);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position ) {
        final ApkInfoExtractor apkInfoExtractor = new ApkInfoExtractor(context1);
        final  String ApplicationPackageName = stringList.get(position);
        String AppName = apkInfoExtractor.GetAppName(ApplicationPackageName);
        Drawable AppIcon = apkInfoExtractor.getAppIconByPackageName(ApplicationPackageName);
        viewHolder.textView_App_Name.setText(AppName);
        viewHolder.imageView.setImageDrawable(AppIcon);

        //Adding click listener on CardView to open clicked application directly from here .
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

            Intent intent = context1.getPackageManager().getLaunchIntentForPackage(ApplicationPackageName);
            if (intent != null) {

                context1.startActivity(intent);

            } else {

                Toast.makeText(context1, ApplicationPackageName + " Error, Please Try Again.", Toast.LENGTH_LONG).show();
            }
        }
        });
    }
    @Override
    public int getItemCount(){
        return stringList.size();
    }
}
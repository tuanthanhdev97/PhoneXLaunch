package skyfree.com.phonexlaunche;



import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinhtuanthanh on 21/03/2018.
 */

public class Fragment_1 extends Fragment {
    RecyclerView recyclerView;
    AppsAdapter adapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    private static final String KEY_COLOR = "key_position";
    List<String> list1;
    List<String> list2;
    List<String> list3;
    List<String> listPakage;
    ApkInfoExtractor apkInfoExtractor;
    String[] Namepakage;

    public Fragment_1() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public static Fragment_1 newInstance(int position) {

        Fragment_1 fragment = new Fragment_1();
        Bundle b = new Bundle();
        b.putInt(KEY_COLOR, position);

        fragment.setArguments(b);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        listPakage = new ArrayList<>();
        apkInfoExtractor = new ApkInfoExtractor(getActivity());
        final View v = inflater.inflate(R.layout.test_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        recyclerViewLayoutManager = new GridLayoutManager(getActivity(), 4);
        // Passing the column number 1 to show online one column in each row.
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        listPakage = apkInfoExtractor.GetAllInstalledApkInfo();

//        switch (getArguments().getInt(KEY_COLOR)) {
//            case 1:
//                for (int i = 0;i<16;i ++){
//                    list1.add(listPakage.get(i));
//                }
//                adapter = new AppsAdapter(getActivity(),list1);
//                break;
//            case 2:
//                for (int i = 15;i<listPakage.size()-list1.size();i ++){
//                    list2.add(listPakage.get(i));
//                }
//                adapter = new AppsAdapter(getActivity(),list2);
//                break;
//            case 3:
//                for (int i = 10;i<listPakage.size()-list1.size();i ++){
//                    list2.add(listPakage.get(i));
//                }
//                adapter = new AppsAdapter(getActivity(),list2);
//                break;
//            case 4:
//                adapter = new AppsAdapter(getActivity(),listPakage);
//                break;
//            case 5:
//                adapter = new AppsAdapter(getActivity(),listPakage);
//                break;
//        }
        adapter = new AppsAdapter(getActivity(),listPakage);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return v;

    }
}
package skyfree.com.phonexlaunche;
//
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

//
///**
// * Created by dinhtuanthanh on 21/03/2018.
// */
//
 public class AppModel {
    private String appName;
    private Drawable appIcon;
    private String pakageName;

    public AppModel() {
    }

    public AppModel(String appName, Drawable appIcon, String pakageName) {
        this.appName = appName;
        this.appIcon = appIcon;
        this.pakageName = pakageName;
    }

    public String getAppName() {
        return appName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public String getPakageName() {
        return pakageName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public void setPakageName(String pakageName) {
        this.pakageName = pakageName;
    }
}



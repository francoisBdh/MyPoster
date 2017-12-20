package view.activity;

import android.os.Bundle;
import android.os.Handler;

import model.contante.Constant;

import java.util.HashMap;import fr.eseo.dis.franc.posterapplication.R;

public class SplashActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set splash Layout
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HashMap<String,String> map = new HashMap<>();
                finishWithResult(view.activity.ServiceActivity.DISPLAY_ACTIVITY_LOGIN,map);
            }
        }, Constant.TIME_SPLASH_SCREEN);
    }
}

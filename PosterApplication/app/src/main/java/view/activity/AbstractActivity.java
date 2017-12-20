package view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import fr.eseo.dis.franc.posterapplication.R;
import java.util.HashMap;


public abstract class AbstractActivity extends AppCompatActivity {

    protected boolean drawerOpen;
    protected HashMap<String, String> mapParams;

    private boolean isRegistered = false;

    /**
     * Process called at the creation of the activity that extends this class
     * @param savedInstanceState : the saved instance state
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mapParams = new HashMap<>();
            for (String key : extras.keySet()) {
                try {
                    mapParams.put(key, (String) extras.get(key));
                } catch (ClassCastException e) {

                }
            }
        }
    }

    public void sendServiceRequest(Context context, String requestAction) {
        Intent intent = new Intent();
        intent.setAction(requestAction);
        context.sendBroadcast(intent);
    }

    /////////////////////////////////
    // END OF BROADCAST MANAGEMENT //
    /////////////////////////////////

    /**
     * Process called by the user to finish the activity
     */
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        drawerOpen = false;
    }

    /**
     * Process called when an activity will be started. This process override the super
     * class in order to set the animation of the transition
     * @param intent : the intent to change the activity
     * @param requestCode : the request code of the activity created
     */
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /**
     * Process called to finish the activity with a result and params
     * @param resultCode : the result code of the activity that will be destroyed
     * @param mapParams : the map params to pass between activities
     */
    protected void finishWithResult(int resultCode, HashMap<String, String> mapParams) {
        Intent intent = new Intent();
        if (mapParams != null) {
            for (String key : mapParams.keySet()) {
                String value = mapParams.get(key);
                intent.putExtra(key, value);
            }
        }
        setResult(resultCode, intent);
        finish();
    }

    /**
     * Process called to finish the activity with a result
     * @param resultCode : the result code of the activity that will be destroyed
     */
    protected void finishWithResult(int resultCode) {
        Intent intent = new Intent();
        setResult(resultCode, intent);
        finish();
    }

    /**
     * Process called to close the drawer of the activity
     */
    protected void closeDrawer() {

    }

    /**
     * Process called when the user click on the back of his device
     */
    @Override
    public void onBackPressed() {
        if (drawerOpen) {
            closeDrawer();
        }
    }
}
package service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;

import utils.LogUtils;

public class AppService extends Service {

    public static final String REQUEST_ACTIVITY_PROCESS_NOTIFY_START_SESSION = "REQUEST_ACTIVITY_PROCESS_NOTIFY_START_SESSION";
    public static final String REQUEST_ACTIVITY_PROCESS_NOTIFY_END_SESSION = "REQUEST_ACTIVITY_PROCESS_NOTIFY_END_SESSION";
    public static final String REQUEST_ACTIVITY_PROCESS_NOTIFY_CONNECTION = "REQUEST_ACTIVITY_PROCESS_NOTIFY_CONNECTION";
    public static final String REQUEST_ACTIVITY_PROCESS_NOTIFY_DISCONNECTION = "REQUEST_ACTIVITY_PROCESS_NOTIFY_DISCONNECTION";
    public static final String REQUEST_ACTIVITY_PROCESS_INFORM_SENSORS = "REQUEST_ACTIVITY_PROCESS_INFORM_SENSORS";
    public static final String REQUEST_ACTIVITY_PROCESS_SAVE_SESSION = "REQUEST_ACTIVITY_PROCESS_SAVE_SESSION";

    public static final String REQUEST_SERVICE_PROCESS_ASK_SENSORS = "REQUEST_SERVICE_PROCESS_ASK_SENSORS";
    public static final String REQUEST_SERVICE_PROCESS_START_SAVING = "REQUEST_SERVICE_PROCESS_START_SAVING";
    public static final String REQUEST_SERVICE_PROCESS_STOP_SAVING = "REQUEST_SERVICE_PROCESS_STOP_SAVING";
    public static final String REQUEST_SERVICE_PROCESS_DELETE_SAVING = "REQUEST_SERVICE_PROCESS_DELETE_SAVING";


    public static final String REQUEST_SERVICE_CONNECTION_OK = "REQUEST_SERVICE_CONNECTION_OK";
    public static final String REQUEST_ACTIVITY_PROCESS_CONNECTION_OK = "REQUEST_ACTIVITY_PROCESS_CONNECTION_OK";
    public static final String REQUEST_ACTIVITY_PROCESS_CONNECTION_FAILED = "REQUEST_ACTIVITY_PROCESS_CONNECTION_FAILED";


    private boolean isRegistered = false;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}



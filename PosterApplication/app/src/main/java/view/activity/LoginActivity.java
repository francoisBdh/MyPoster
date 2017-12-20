package view.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import view.activity.AbstractActivity;
import fr.eseo.dis.franc.posterapplication.R;

public class LoginActivity extends AbstractActivity {
    private EditText etLoginUsername;
    private EditText etLoginPassword;
    private TextView tvMessageError;
    private View layoutConnectionInProgress;
    private ProgressBar pcLoginAuth;
    private Button btnLoginAction;

    private View btDisplayBluetoothActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginUsername = (EditText) findViewById(R.id.etLoginUsername);
        etLoginPassword = (EditText) findViewById(R.id.etLoginPassword);
        tvMessageError = (TextView) findViewById(R.id.tvMessageError);
        layoutConnectionInProgress = findViewById(R.id.layoutConnectionInProgress);
        pcLoginAuth = (ProgressBar) findViewById(R.id.pcLoginAuth);
        btnLoginAction = (Button) findViewById(R.id.btnLoginAction);

        initView();
        initListener();
    }

    private void initView() {
        pcLoginAuth.getIndeterminateDrawable().setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
        layoutConnectionInProgress.setVisibility(View.INVISIBLE);
        tvMessageError.setVisibility(View.INVISIBLE);
    }

    private void initListener() {
        btnLoginAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLoginAction.setVisibility(View.INVISIBLE);
                layoutConnectionInProgress.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finishWithResult(view.activity.ServiceActivity.DISPLAY_ACTIVITY_MAIN);
                    }
                }, 2000);
            }
        });
    }

}

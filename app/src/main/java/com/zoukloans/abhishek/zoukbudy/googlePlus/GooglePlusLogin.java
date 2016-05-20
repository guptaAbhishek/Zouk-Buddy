package com.zoukloans.abhishek.zoukbudy.googlePlus;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zoukloans.abhishek.zoukbudy.R;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

import android.content.DialogInterface.OnClickListener;

public class GooglePlusLogin extends AppCompatActivity implements OnClickListener,ConnectionCallbacks,OnConnectionFailedListener{

    private static final int RC_SIGN_IN = 0;

    private static final String TAG = "GooglePlusLogin";

    private static final int PROFILE_PIC_SIZE = 400;

    private GoogleApiClient mGoogleApiClient;

    private boolean mIntentInProgress;

    private boolean mSignInClicked;

    private ConnectionResult mConnectionResult;

    private SignInButton btnSignIn;
    private Button btnSignOut,btnRevokeAccess;
    private ImageView imgProfilePic;
    private TextView txtName,txtEmail;
    private LinearLayout llProfileLayout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_plus_login);

        btnSignIn = (SignInButton) findViewById(R.id.btn_sign_in);
        imgProfilePic = (ImageView) findViewById(R.id.profile_pic);
        txtName = (TextView) findViewById(R.id.txtName);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}

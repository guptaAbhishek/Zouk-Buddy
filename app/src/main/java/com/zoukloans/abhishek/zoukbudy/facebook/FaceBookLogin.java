package com.zoukloans.abhishek.zoukbudy.facebook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.AttributeSet;
import android.view.View;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.zoukloans.abhishek.zoukbudy.R;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import com.facebook.GraphRequest;

import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;

public class FaceBookLogin extends AppCompatActivity {

    LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        facebookInitialize();
        setContentView(R.layout.activity_face_book_login);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_friends");
        getFriendList(loginButton);

    }


    protected void getFriendList(LoginButton loginButton){
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequestAsyncTask graphRequestAsyncTask = new GraphRequest(
                        loginResult.getAccessToken(),
                        "/me/friends",
                        null,
                        HttpMethod.GET,
                        new GraphRequest.Callback() {
                            @Override
                            public void onCompleted(GraphResponse response) {
                                Intent fbFriendList = new Intent(FaceBookLogin.this,FriendList.class);
                                try{
                                    JSONArray rawName = response.getJSONObject().getJSONArray("data");
                                    fbFriendList.putExtra("jsondata",rawName.toString());
                                    startActivity(fbFriendList);
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                ).executeAsync();



                String a = loginResult.getAccessToken().getUserId();
                a += loginResult.getAccessToken().getToken();
                Toast.makeText(getApplicationContext(),a,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    protected void facebookInitialize(){
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        AppEventsLogger.activateApp(this);
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }


}

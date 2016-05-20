package com.zoukloans.abhishek.zoukbudy.facebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zoukloans.abhishek.zoukbudy.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class FriendList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);

        Intent fbFriendIntent = getIntent();
        String jsonData = fbFriendIntent.getStringExtra("jsondata");

        JSONArray friendList;

        ArrayList<String> friends = new ArrayList<String>();
        try{
            friendList = new JSONArray(jsonData);
            for(int i=0;i<friendList.length();i++){
                friends.add(friendList.getJSONObject(i).getString("name"));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_friend_list,friends);
        ListView listView = (ListView) findViewById(R.id.friendListView);
        listView.setAdapter(adapter);



    }
}

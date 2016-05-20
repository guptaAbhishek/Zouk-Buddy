package com.zoukloans.abhishek.zoukbudy.message;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import android.widget.ListView;
import android.widget.ArrayAdapter;


/**
 * Created by abhishek on 17/05/16.
 */
public class SmsActivity extends Activity implements AdapterView.OnItemClickListener {

    private static SmsActivity inst;

    ArrayList<String> smsMessagesList = new ArrayList<String>();
    ListView smsListView;
    ArrayAdapter arrayAdapter;

    public static SmsActivity instance() {
        return inst;
    }

    @Override
    public void onStart(){
        super.onStart();
        inst = this;
    }





    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}

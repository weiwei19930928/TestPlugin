package com.weiwei.maventest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String ACTION_USB_PRODUCT_ID = "com.justsy.mdm.action.peripheral.USB_PRODUCT_ID";
    PeripheralReceiver peripheralReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        peripheralReceiver = new PeripheralReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_USB_PRODUCT_ID);
        intentFilter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
        intentFilter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
        registerReceiver(peripheralReceiver,intentFilter);

        String a = "12345";
        String b = "123456";
        String c = "1234";
        String d = "12345";
        String e = "123456";

//        Set<String> set = new HashSet<>();
//        set.add(a);
//        set.add(b);
//        set.add(c);
//        set.add(d);
//        set.add(e);

        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Set<String> set = new HashSet<>();
                set.add(a);
                set.add(b);
                set.add(c);
                set.add(d);
                set.add(e);

                SPUtil.putStringSet(MainActivity.this, set);
            }
        });


        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.justsy.mdm.action.peripheral.USB_PRODUCT_ID");
                intent.putExtra("product_id", "1234567890123");
                sendBroadcast(intent);
//                Set<String> ret = SPUtil.getStingSet(MainActivity.this, "weiwei");
//                Toast.makeText(MainActivity.this, String.valueOf(ret.size()), Toast.LENGTH_SHORT).show();
//                for (String value : ret) {
////                    Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
//                    Log.d(TAG, "onClick: "+value);
//                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(peripheralReceiver);
    }
}
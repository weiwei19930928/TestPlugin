package com.weiwei.maventest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;


/**
 * @Author weiwei
 * @Date 2022.5.18 11:31
 */
public class PeripheralReceiver extends BroadcastReceiver {

    private static final String TAG = "PeripheralReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        Log.d(TAG, "onReceive: weiwei" + action);
//        Toast.makeText(context, action, Toast.LENGTH_SHORT).show();

        if (TextUtils.equals("com.justsy.mdm.action.peripheral.USB_PRODUCT_ID", action)) {
            String s = intent.getStringExtra("product_id");
            Log.d(TAG, "onReceive: " + s);
            Toast.makeText(context, s, Toast.LENGTH_LONG).show();
            //usb拔出广播
        } else if (UsbManager.ACTION_USB_DEVICE_DETACHED == action) {
            Toast.makeText(context, "设备拔出来", Toast.LENGTH_LONG).show();
            Log.d(TAG, "onReceive: " + "设备拔出来");
        } else if (UsbManager.ACTION_USB_DEVICE_ATTACHED == action) {
            Toast.makeText(context, "设备插入", Toast.LENGTH_LONG).show();
            Log.d(TAG, "onReceive: " + "设备插入");
            Intent intent1 = new Intent();
            intent1.setAction("com.justsy.mdm.action.peripheral.USB_PRODUCT_ID");
            intent1.putExtra("product_id", "1234567890");
            Toast.makeText(context, "发送广播", Toast.LENGTH_LONG).show();
            context.sendBroadcast(intent1);
        } else if (action == "android.hardware.usb.action.USB_STATE") {

            boolean connected = intent.getExtras().getBoolean("connected");

            Toast.makeText(context, "aciton =" + connected, Toast.LENGTH_SHORT).show();
        }


    }
}

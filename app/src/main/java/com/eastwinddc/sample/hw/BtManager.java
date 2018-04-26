package com.eastwinddc.sample.hw;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import java.util.List;
import java.util.Set;

/**
 * Created by ewinddc on 2018/4/26.
 */

public class BtManager {
    private static final String TAG = BtManager.class.getSimpleName();
    private static BtManager instance ;
    public static BtManager getInstance(){
        if(instance == null){
            instance = new BtManager();
        }
        return instance;
    }
    private BtManager(){
    }
    private BluetoothAdapter bluetoothAdapter;
    public void init(){
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(!bluetoothAdapter.isEnabled()){
            bluetoothAdapter.enable();
        }
    }

    public String getBondedName(){
        Set<BluetoothDevice> deviceSet= bluetoothAdapter.getBondedDevices();
        StringBuilder name =new StringBuilder("name:\n");
        for(BluetoothDevice device:deviceSet){
            name.append(device.getName());
            name.append("\n");
        }
        return name.toString();
    }
}

package com.ljx.demo.androidtoolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Map<String,String> map = new HashMap<>();
        map.put("a","a1");
        map.put("b",null);
        map.put("c","c1");
        for(String key:map.keySet()){
            String s = map.get(key);
            Log.d("aaa",""+s);
        }
    }
}

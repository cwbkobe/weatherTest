package com.example.caiwb.weathertest;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.caiwb.weathertest.service.AutoUpdateService;

/**
 * Created by caiwb on 2018/3/15.
 */

public class PreferencesActivity extends PreferenceActivity implements
        Preference.OnPreferenceChangeListener, OnSharedPreferenceChangeListener{

    private static final String TAG = "PreferencesActivity";
    private static final String SERVICE_NAME = "com.example.caiwb.weathertest.service";
    private SharedPreferences preferences;
    private SwitchPreference switchPreference;
    private ListPreference listPreference;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);//活动布局显示在状态栏上面
            getWindow().setStatusBarColor(Color.TRANSPARENT);//将状态栏颜色置为透明
        }
        this.getWindow().setBackgroundDrawableResource(R.drawable.timg);
        initView();
    }

    private void initView() {
        switchPreference = (SwitchPreference) findPreference("switch");
        listPreference = (ListPreference)findPreference("list");
        switchPreference.setOnPreferenceChangeListener(this);
        listPreference.setOnPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        preferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        freshUI();
        preferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        String key = preference.getKey();
        setView(key, newValue);
        return true;
    }

    private void freshUI() {
        switchPreference.setChecked(preferences.getBoolean("switch", false));
        listPreference.setSummary(preferences.getString("list", "1小时") + "小时");
        if(switchPreference.isChecked()) {
            listPreference.setEnabled(true);
        } else {
            listPreference.setEnabled(false);
        }
        if(listPreference.isEnabled()) {
            if(!isServiceRunning())
                StartAutoService(preferences.getString("list", "1"));
        }
    }

    private boolean isServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (SERVICE_NAME.equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private void StartAutoService(String value) {
        Intent intent = new Intent(this, AutoUpdateService.class);
        intent.putExtra("value", value);
        startService(intent);
    }

    private void StopAutoService() {
        Intent intent = new Intent(this, AutoUpdateService.class);
        stopService(intent);
    }

    private void setView(String key, Object newValue) {
        if(key.equals("switch") && switchPreference != null) {
            Log.i(TAG, "ischeck : " + newValue.toString());
            if(newValue.toString().equals("true")) {
                listPreference.setEnabled(true);
            } else {
                listPreference.setEnabled(false);
            }
        } else if(key.equals("list") && listPreference.isEnabled()) {
            listPreference.setSummary(newValue + "小时");
            if(!newValue.equals(preferences.getString("list", null))) {
                if(isServiceRunning()) {
                    StopAutoService();
                } else {
                    StartAutoService((String) newValue);
                }
            }
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}

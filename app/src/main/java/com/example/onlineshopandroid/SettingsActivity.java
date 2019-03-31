package com.example.onlineshopandroid;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class SettingsActivity extends AppCompatActivity
{
    private SharedPreferences settings;
    private CheckBox licenseAgreementCheckBox;
    private SharedPreferences.Editor settingsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        this.settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        this.licenseAgreementCheckBox = (CheckBox) findViewById(R.id.licenseAgreementCheckbox);
        this.settingsEditor = this.settings.edit();
        restoreChecked();
    }

    public void onLicenseAgreementChanged(View view)
    {
        this.settingsEditor.putBoolean("isLicenseAgreed", this.licenseAgreementCheckBox.isChecked());
        this.settingsEditor.commit();
    }

    public void restoreChecked()
    {
        this.licenseAgreementCheckBox.setChecked(this.settings.getBoolean("isLicenseAgreed", false));
    }
}

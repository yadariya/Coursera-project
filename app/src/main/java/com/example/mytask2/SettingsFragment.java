package com.example.mytask2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class SettingsFragment extends Fragment {

    SharedPreferences sharedPreferences;
    RadioGroup settingsGroup;
    RadioButton browser;

    Button settingsBackButton;

    public static Fragment newInstance() {
        return new SettingsFragment();
    }


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.settings_layout, container, false);
        settingsGroup = v.findViewById(R.id.settings_group);
        settingsBackButton = v.findViewById(R.id.settings_back_button);
        settingsBackButton.setOnClickListener(BackSettingsButton);
        settingsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                sharedPreferences = getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);
                int selectedId = settingsGroup.getCheckedRadioButtonId();
                browser = v.findViewById(selectedId);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String selectedBrowser = browser.getText().toString();
                editor.putString("browser_key", selectedBrowser).apply();

            }
        });
        return v;
    }


    View.OnClickListener BackSettingsButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            fm.popBackStack();
        }
    };

}

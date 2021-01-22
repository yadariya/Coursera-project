package com.example.mytask2;


import androidx.fragment.app.Fragment;

public class MainActivity extends SingleFragment {
    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }
}

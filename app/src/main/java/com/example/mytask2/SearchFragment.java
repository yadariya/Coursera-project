package com.example.mytask2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class SearchFragment extends Fragment {

    Button searchButton;
    EditText searchEditText;
    Button backSearchButton;
    SharedPreferences getData;

    public static Fragment newInstance() {
        return new SearchFragment();
    }

    View.OnClickListener SearchButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
            getData = getActivity().getSharedPreferences("myPref", Context.MODE_PRIVATE);
            String selectedbrowser = getData.getString("browser_key", "Google");
            assert selectedbrowser != null;
            if (selectedbrowser.equals("Google")) {
                openURL.setData(Uri.parse("https://www.google.com/#q=" + searchEditText.getText()));
                startActivity(openURL);
            }
            if (selectedbrowser.equals("Yandex")) {
                openURL.setData(Uri.parse("https://www.yandex.ru/#q=" + searchEditText.getText()));
                startActivity(openURL);
            }
            if (selectedbrowser.equals("Bing")) {
                openURL.setData(Uri.parse("https://www.bing.com/#q=" + searchEditText.getText()));
                startActivity(openURL);
            }

        }
    };
    View.OnClickListener BackSearchButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fm = getActivity().getSupportFragmentManager();
            fm.popBackStack();
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_layout, container, false);
        searchButton = v.findViewById(R.id.search_button);
        searchEditText = v.findViewById(R.id.edit_search_text);
        backSearchButton = v.findViewById(R.id.search_back_button);
        searchButton.setOnClickListener(SearchButton);
        backSearchButton.setOnClickListener(BackSearchButton);

        return v;
    }
}

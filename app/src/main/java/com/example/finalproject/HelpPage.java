package com.example.finalproject;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;



public class HelpPage extends AppCompatActivity {

    private TextView mHelp, mReportProblem, mTheContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);

        setTitle("Help");
        HelpPageFragment fragment = new HelpPageFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.help_scroll_view, fragment).commit();
        uiHelppage();
    }

    private void uiHelppage() {

    }
}

package com.example.finalproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HelpPageFragment extends Fragment {
    private String intro;
    private String q1,q2,q3,q4;
    private String a1,a2,a3,a4;
    private String footer;
    public HelpPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.a3 = "The game is all about learning over time. Firstly, choose your game. This will consume a heart. Secondly, choose your level and press the play button. Then read the question, select your answers and press continue until the end of the game. At any time, if you would like to stop playing, you can always use your Android device on screen buttons, or the quit button on screen.";
        this.footer = "Just like the purpose of this app, Psyke Developers is also focused on the continuous learning and improvement journey. We will look to expand this app in the future after getting feedback. Until then, we wish you all the best with your test!";
        this.intro = "We hope you are enjoying learning with Psyke! If you have any issues or need help, please read the FAQ below. If it isn’t answered, please send an email to psyke@psyke.com.au";
        this.q1 = "Why can’t I play any of the games?";
        this.q2 = "How do I select the levels?";
        this.q3 = "How do I play the games?";
        this.a1 = "Psyke uses a life system, indicated by the hearts shown on the top right corner of your screen. This indicates the number of games you can play every 24 hours. Take a break, relax and reflect, then come back and play more!";
        this.a2 = "Upon choosing a game, the level can be chosen by clicking on the number. This gives you, the user, an option to choose different levels and test yourself!";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_help_page, container, false);
        ((TextView) v.findViewById(R.id.theContent6)).setText(a3);
        ((TextView) v.findViewById(R.id.theContent8)).setText(footer);
        ((TextView) v.findViewById(R.id.theContent)).setText(intro);
        ((TextView) v.findViewById(R.id.theContent2)).setText(q1);
        ((TextView) v.findViewById(R.id.theContent7)).setText(q3);
        ((TextView) v.findViewById(R.id.theContent5)).setText(a2);
        ((TextView) v.findViewById(R.id.theContent4)).setText(q2);
        ((TextView) v.findViewById(R.id.theContent3)).setText(a1);


        return v;
    }
}

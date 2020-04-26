//package com.example.finalproject;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.os.CountDownTimer;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ProgressBar;
//import android.widget.RadioButton;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//
//import com.example.finalproject.entities.vocab.VocabQuestion;
//import com.example.finalproject.entities.vocab.VocabResponse;
//import com.example.finalproject.entities.vocab.VocabService;
//import com.example.finalproject.entities.vocab.word.PartOfSpeech;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Queue;
//
//import retrofit2.Call;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class VocabGameActivity extends AppCompatActivity {
//    private static final String BASE_URL_MW = "https://www.dictionaryapi.com/";
//    private static final String BASE_URL = "https://words.bighugelabs.com/";
//    private static final String TAG = "VocabFragment";
//    public List<String> syns;
//    public List<String> ants;
//    private HashMap<String, PartOfSpeech> wordThesaurus;
//
//    private static final int TOTAL_TIME = 30;
//    public String player;
//
//    private TextView timerView;
//    private RadioButton ans1, ans2, ans3, ans4, ans5;
//    private ProgressBar progressBar;
//    private Button nextButton, quitButton;
//    private RadioGroup ansGroup;
//    private TextView questionView, nameDisplay, scoreDisplay;
//    private Queue<VocabQuestion> questions;
//    private VocabQuestion currQuestion;
//    private int score, correct, numQuestions = 0;
//    private int secondsRemaining = TOTAL_TIME;
//    private CountDownTimer gameTimer;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_game);
//
//        GetThesaurausTask getThesaurus = new GetThesaurausTask();
//        wordThesaurus = new HashMap<>();
//        String[] Params = {"fast", "salt"};
//        getThesaurus.execute(Params);
//    }
//    private class GetThesaurausTask extends AsyncTask<String, Void, HashMap<String, PartOfSpeech>> {
//
//        @Override
//        protected HashMap<String, PartOfSpeech> doInBackground(String... words) {
//            try {
//                for(String word :  words) {
//                    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
//                            .addConverterFactory(GsonConverterFactory.create()).build();
//                    VocabService service = retrofit.create(VocabService.class);
//                    Call<VocabResponse> problemCall = service.getThesaurusEntry(word);
//
//                    Response<VocabResponse> response = problemCall.execute();
//                    VocabResponse vR = response.body();
//                    if (vR != null) {
//                        wordThesaurus.put(word, vR.getWord());
//                    }
//                }
//                return wordThesaurus;
//
//            } catch (IOException e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//        //Override the onPostExecute method to run when the background thread has completed (when the coins have been retrieved)
//        @Override
//        protected void onPostExecute(HashMap<String, PartOfSpeech> words) {
//            Log.d(TAG, "onPostExecute: SUCCESS");
//            Log.d(TAG, words.toString());
////            updateUi(wordThesaurus);
//        }
//    }
//
//    private void updateUi() {
//        CountDownTimer timers = new CountDownTimer(5000,1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                secondsRemaining--;
//                timer.setText(Integer.toString(secondsRemaining) +"sc");
//                progressBar.setProgress(5 - secondsRemaining);
//            }
//            @Override
//            public void onFinish() {
//                rb1.setEnabled(false);
//                rb2.setEnabled(false);
//                rb3.setEnabled(false);
//                rb4.setEnabled(false);
//            }
//        };
//        View v = getView();
//        radio_g = v.findViewById(R.id.answersgrp);
//        rb1 = v.findViewById(R.id.a1);
//        rb2 = v.findViewById(R.id.a2);
//        rb3 = v.findViewById(R.id.a3);
//        rb4 = v.findViewById(R.id.a4);
//        tv = v.findViewById(R.id.tvque);
//        displayName = v.findViewById(R.id.nameView);
//        score = v.findViewById(R.id.scoreMath);
//        number = v.findViewById(R.id.score);
//        timer = v.findViewById(R.id.timerQ);
//        nextButton = v.findViewById(R.id.nextQButton);
//        quitbutton = v.findViewById(R.id.buttonquit);
//        progressBar = v.findViewById(R.id.progressBar);
//
//        nextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                RadioButton answe = v.findViewById(radio_g.getCheckedRadioButtonId());
//                String ansText = answe.getText().toString();
//                if (score != null) {
////                        score.setText(""+if the ansewer is correct);};
////
////                    if( the question if condition) {
////                        tv.setText(the question set);
////                        rb1.setText(option set);
////                        rb2.setText(option set);
////                        rb3.setText(option set);
////                        rb4.setText(option set);
////                    } else {
////                        marks=correct;
////                        Intent in = new Intent(getActivity(),EndPageActivity.class);
////                        startActivity(in);
////
////                    }
//                    radio_g.clearCheck();
//                    timers.start();
//                }
//            }
//        });
//        quitbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity() , EndPageActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        Intent intent = new Intent();
//        String namePlayer = intent.getStringExtra("myname");
//        displayName.setText("Hello " + namePlayer);
//    }
//}

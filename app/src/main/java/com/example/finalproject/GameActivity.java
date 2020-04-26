package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.entities.math.MathResponse;
import com.example.finalproject.entities.math.MathService;
import com.example.finalproject.entities.vocab.VocabQuestion;
import com.example.finalproject.entities.vocab.VocabResponse;
import com.example.finalproject.entities.vocab.VocabService;
import com.example.finalproject.game.GameLevelsActivity;
import com.example.finalproject.game.GameListAdapter;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.github.dhiraj072.randomwordgenerator.RandomWordGenerator;

public class GameActivity extends AppCompatActivity {

    private final static String AUTH_TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiYzhiODlmOTk3MGQwMTQxNGUwM2JiODcxMGI0MTRkZjhjNzczNTFlYWZiZTRhYmRiMDk3OWJiZmRmMDBkZTMwNDg2MjY1MTBkNzc0Yjc1ZmEiLCJpYXQiOjE1ODczMzk3NTMsIm5iZiI6MTU4NzMzOTc1MywiZXhwIjoxNjE4ODc1NzUzLCJzdWIiOiI2ODMiLCJzY29wZXMiOltdfQ.WOw4b0tJJaCOaCoQWq3P_Uv803qzXCa4lG486F0EQeK82FDS3OEnQjj5nQStjsLXhP3ApPQm86eCAFKgpXOuCwA8zv3GXNaB3cjZhIuFK-uUfyDHNlg4dLkU2kaFimJafTsp47xN6R41hs5qbpOcDKBKLlsLHw-tDTTpBRyDQ3AsTTQDC3oLqtMfc3cKWAmUxvZFt8GPn43g6NuHqz_XWeCrbA57v7DtU910swtGc-tg0xaGYaxnfk4eGmdDF0l21oZUGAi42yYVCjhrmFryJnEfI-_tVu-tkHS3EpfZEIsVlbCkof4lHFNXHN8ImfBu6ZLZD4r9hkz2HnRiMPOTjyKnVTdTqQ8GZukrWBJxbpXYsW9J-nhqVt0JnTAC-gMHItH_TnsfuOA8kjM8JwtvyvTEKMsCmc_dHAxzvm6RUxc2tL8BlEwClVoJX4kVbISMpOVK87leEeWCDRXTlJ_1ytiLWlSo-RnCZM4VvWGJjog8BH5GqkYXOvwngZ6XWlgtU6CtfWD6vDHma8hZPozEBbwllI9M88wF1aYlSWYbQOg0a-fPr1snPJwQRsNvQheLXlQUI7vzI8XINf8mn7UXoXkD14vCv081iud-zmdCEgHjPsXDjwl3-4lj5_OSBfaMqjviiKddyy5sHtgm68YL6RmS1dtFqCyvcsFE12H_LD8";
    private static final String MATH_BASE_URL = "https://studycounts.com/";
    public static final String TAG = "LevelDetailFragment";
    private static final String VOCAB_BASE_URL_MW = "https://www.dictionaryapi.com/";
    private static final String VOCAB_BASE_URL = "https://words.bighugelabs.com/";

    private static final int TOTAL_TIME = 45;
    public String player, gameName;

    private RadioButton ans1, ans2, ans3, ans4, ans5;
    private ProgressBar progressBar;
    private Button nextButton, quitButton;
    private RadioGroup ansGroup;
    private TextView timerView, questionView, nameDisplay, scoreDisplay;
    private Queue<QuizQuestion> questions;
    private QuizQuestion currQuestion;
    private int score, correct, numQuestions = 0;
    private int secondsRemaining = TOTAL_TIME;
    private CountDownTimer gameTimer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        player = intent.getStringExtra(MainActivity.NAME_TAG);
        if (player == null) player = "";
        gameName = intent.getStringExtra(GameListAdapter.GAME_NAME_TAG);

        if (gameName.equals("Math")) {
            GetMathProblemTask getProblems = new GetMathProblemTask();
            getProblems.execute();
        } else {
            GetThesaurausQuestionTask getProblems = new GetThesaurausQuestionTask();
            getProblems.execute();
        }
        questions = new LinkedList<>();

        ans1 = findViewById(R.id.a1);
        ans2 = findViewById(R.id.a2);
        ans3 = findViewById(R.id.a3);
        ans4 = findViewById(R.id.a4);
        ans5 = findViewById(R.id.a5);
        setOptionsEnabled(false);
        timerView = findViewById(R.id.timerQ);
        nextButton = findViewById(R.id.nextQButton);
        quitButton = findViewById(R.id.buttonquit);
        progressBar = findViewById(R.id.progressBar);
        ansGroup = findViewById(R.id.answersgrp);
        questionView = findViewById(R.id.tvque);
        nameDisplay = findViewById(R.id.nameView);
        scoreDisplay = findViewById(R.id.score);

        scoreDisplay.setText("" + score);
        nameDisplay.setText("Hello " + player + "!");
    }

    private class GetMathProblemTask extends AsyncTask<Void, Void, MathResponse> {

        @Override
        protected MathResponse doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 10; i++) {
                    Retrofit retrofit = new Retrofit.Builder().baseUrl(MATH_BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create()).build();

                    Call<MathResponse> problemCall = retrofit.create(MathService.class)
                            .getMathProblem(AUTH_TOKEN);
                    Response<MathResponse> response = problemCall.execute();
                    if (i < 9) questions.add(response.body());
                    else currQuestion = response.body();
                    numQuestions+=1;
                }
                Log.d(TAG, "doInBackground: SUCCESS");
                return (MathResponse) currQuestion;
            } catch (IOException e) {
                Log.d(TAG, "doInBackground: FAIL");

                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(MathResponse response) {
            updateUi();
            if (response == null) currQuestion = (MathResponse) questions.poll();
            if (currQuestion == null) waitForAPI();
            else {
                updateQuestion();
                //start a 10 second timer for each question
                gameTimer = generateTimer(TOTAL_TIME).start();
            }
        }
    }

    private class GetThesaurausQuestionTask extends AsyncTask<Void, Void, VocabQuestion> {

        @Override
        protected VocabQuestion doInBackground(Void... voids) {
            try {
                int i = 0;
                while (i<10){
                    String word = RandomWordGenerator.getRandomWord();

                    VocabQuestion question = generateQuestion(word);
                        if (question!=null) {
                            questions.add(question);
                            i++;
                        }
                }
                numQuestions = questions.size();
                currQuestion = questions.poll();
                return (VocabQuestion) currQuestion;

            } catch(IllegalStateException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        private VocabQuestion generateQuestion(String word) throws IOException {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(VOCAB_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
            VocabService service = retrofit.create(VocabService.class);
            Call<VocabResponse> problemCall;
            Response<VocabResponse> response;
            try {
                problemCall = service.getThesaurusEntry(word);
                Log.d(TAG, problemCall.request().url().toString());
                response = problemCall.execute();
            } catch(RuntimeException e){
                //some plural words route to old version of API which is an ARRAY and throws a runtime
                //exception so remove the 's' at the end and retry
                problemCall = service.getThesaurusEntry(word.substring(0,word.length()-1));
                Log.d(TAG, problemCall.request().url().toString());
                response = problemCall.execute();
            }
            return constructQuestion(word, response.body());
        }

        private VocabQuestion constructQuestion(String word, VocabResponse response) {
            try {
                return new VocabQuestion(word, response.getWord());
            } catch (Exception e) {
                return null;
            }
        }

        //Override the onPostExecute method to run when the background thread has completed (when the coins have been retrieved)
        @Override
        protected void onPostExecute(VocabQuestion question) {
            Log.d(TAG, "onPostExecute: SUCCESS");
            updateUi();
            if (question == null) currQuestion = (VocabQuestion) questions.poll();
            if (currQuestion == null) waitForAPI();
            else {
                updateQuestion();
                //start a 10 second timer for each question
                gameTimer = generateTimer(TOTAL_TIME).start();
            }
        }
    }

    @Override
    public void onBackPressed()
    {
        if (gameTimer!=null) gameTimer.cancel();
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(MainActivity.NAME_TAG, player);
        startActivity(intent);
    }

    private void waitForAPI() {
        Intent intent =  new Intent(this, GameLevelsActivity.class);
        intent.putExtra(GameListAdapter.GAME_NAME_TAG, gameName);
        intent.putExtra("API_ERROR", true);
        intent.putExtra(MainActivity.NAME_TAG, player);
        startActivity(intent);
    }

    private CountDownTimer generateTimer(int length) {
            return new CountDownTimer(length*1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    secondsRemaining--;
                    timerView.setText(secondsRemaining + "sc");
                    progressBar.setProgress(TOTAL_TIME - secondsRemaining);
                }

                @Override
                public void onFinish() {
                    setOptionsEnabled(false);
                    endGame();
                }
            };
        }

        private void setOptionsEnabled(Boolean b){
            ans1.setEnabled(b);
            ans2.setEnabled(b);
            ans3.setEnabled(b);
            ans4.setEnabled(b);
            ans5.setEnabled(b);
        }

    private void endGame() {
        secondsRemaining = 0;
        Intent intent = new Intent(this, EndPageActivity.class);
        intent.putExtra(GameLevelsActivity.SCORE_TAG, score);
        intent.putExtra(GameLevelsActivity.MARK_TAG, correct);
        intent.putExtra(GameLevelsActivity.NUM_Q_TAG, numQuestions);
        intent.putExtra(MainActivity.NAME_TAG, player);
        intent.putExtra(GameListAdapter.GAME_NAME_TAG, gameName);
        startActivity(intent);
    }

    private void updateUi() {
        if (questions.size() != 0) {
            quitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    endGame();
                    if (gameTimer!=null) gameTimer.cancel();
                }
            });
            score = getScoreAsInt(scoreDisplay.getText().toString());

            nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currQuestion != null) {
                        if (ansGroup.getCheckedRadioButtonId() == -1) {
                            Toast.makeText(getApplicationContext(), "Please select an answer!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        int id = ansGroup.getCheckedRadioButtonId();
                        RadioButton answer = findViewById(id);
                        updateScore(answer.getText().toString());

                        scoreDisplay.setText("" + score);

                        if (!questions.isEmpty()) {
                            currQuestion = questions.poll();
                            updateQuestion();
                        } else {
                            gameTimer.cancel();
                            score = getFinalScore(score, secondsRemaining);
                            endGame();
                        }
                        ansGroup.clearCheck();
                    }
                }
            });
        }
    }

    private void updateQuestion() {
        questionView.setText(currQuestion.getQuestion());
        ans1.setText(currQuestion.getChoices().get(0));
        ans2.setText(currQuestion.getChoices().get(1));
        ans3.setText(currQuestion.getChoices().get(2));
        ans4.setText(currQuestion.getChoices().get(3));
        ans5.setText(currQuestion.getChoices().get(4));
        setOptionsEnabled(true);
        Log.d("ANSWER", currQuestion.getChoices().get(currQuestion.getCorrectChoice()));
    }

    private int getScoreAsInt(String scoreText) {
        try {
            int s = Integer.parseInt(scoreText);
            return s;
        } catch (NumberFormatException e) {
            return score;
        }
    }

    private void updateScore(String answer) {
        boolean isCorrect = answer.equals(currQuestion.getChoices().get(currQuestion.getCorrectChoice()));
        if (isCorrect) {
            Toast.makeText(getApplicationContext(), "Well Done!", Toast.LENGTH_SHORT).show();
            correct++;
            score += calculateScore(secondsRemaining);
        } else {
            Toast.makeText(getApplicationContext(), "Incorrect :(", Toast.LENGTH_SHORT).show();
            if (score <= 0) score = 0;
        }
    }

    private int calculateScore(int time) {
        return time >= 2 ? time/2 : 1;
    }

    private int getFinalScore(int score, int timeLeft) { return score + timeLeft; }
}

package traf1.hejason.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private int highScore = 0, totalQuestions = 43 - 1;
    String correctAnswer;
    TypedArray questionResources, currentQuestion;
    Button restart;
    Button[] answerChoices = new Button[5];
    TextView question, scoreBoard;
    Chronometer cmTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cmTimer = findViewById(R.id.cmTimer);
        cmTimer.start();

        scoreBoard = findViewById(R.id.score);
        scoreBoard.setText(scoreBoard.getText() + "0");

        question = findViewById(R.id.question);

        answerChoices[0] = findViewById(R.id.A);
        answerChoices[1] = findViewById(R.id.B);
        answerChoices[2] = findViewById(R.id.C);
        answerChoices[3] = findViewById(R.id.D);
        answerChoices[4] = findViewById(R.id.E);

        restart = findViewById(R.id.restart);

        questionResources = getResources().obtainTypedArray(R.array.questions);
        updateQuestion();

    }

    @SuppressWarnings("ResourceType")
    protected void updateQuestion() {
        currentQuestion = getResources().obtainTypedArray(questionResources.getResourceId(highScore, -1));
        scoreBoard.setText("" + highScore);
        correctAnswer = currentQuestion.getString(6);
        question.setText(currentQuestion.getString(0));
        ArrayList<String> choices = new ArrayList<>();
        for (int i = 1; i <= 5; i++)
            choices.add(currentQuestion.getString(i));
        int i = 0;
        for (String s : choices) {
            answerChoices[i].setText(s);
            i++;
        }
    }

    public void checkAnswer(View v) {
        if (v.getTag().toString().equals(correctAnswer)) {
            highScore++;
            if (highScore >= totalQuestions) {
                for (Button b : answerChoices)
                    b.setVisibility(View.INVISIBLE);
                v.setBackgroundColor(getResources().getColor(R.color.win));
                gameOver();
            } else {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                updateQuestion();
            }
        } else {
            for (Button b : answerChoices)
                b.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
            gameOver();
        }
    }

    private void gameOver(){
        restart.setVisibility(View.VISIBLE);
        cmTimer.stop();
        cmTimer.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
        String output = "";
        long time = (SystemClock.elapsedRealtime() - cmTimer.getBase()) / 1000;
        if(highScore == 1)
            output = "Game over! You scored " + highScore + " point";
        else if(highScore >= totalQuestions)
            output = "Game over! You got all the questions correct!";
        else
            output = "Game over! You scored " + highScore + " points";
        scoreBoard.setText(output);
    }

    public void restart(View v){
        restart.setVisibility(View.INVISIBLE);
        for (Button b : answerChoices)
            b.setVisibility(View.VISIBLE);
        cmTimer.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        highScore = 0;
        scoreBoard.setText(highScore + "");
        long systemCurrTime = SystemClock.elapsedRealtime();
        cmTimer.setBase(systemCurrTime);
        cmTimer.start();
        updateQuestion();
    }
}


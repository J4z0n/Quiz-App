package traf1.hejason.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
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
    Button[] answerChoices = new Button[5];
    TextView question, scoreBoard;
    Chronometer cmTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cmTimer = findViewById(R.id.cmTimer);
        cmTimer.start();

        scoreBoard = findViewById(R.id.score);
        scoreBoard.setText(scoreBoard.getText() + "0");

        question = findViewById(R.id.question);
        question.setText("epic");

        answerChoices[0] = findViewById(R.id.A);
        answerChoices[1] = findViewById(R.id.B);
        answerChoices[2] = findViewById(R.id.C);
        answerChoices[3] = findViewById(R.id.D);
        answerChoices[4] = findViewById(R.id.E);

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
                    b.setVisibility(View.GONE);
                //v.setVisibility(View.VISIBLE);
                //v.setBackgroundColor(getResources().getColor(R.color.win));
                //gameOverText.setText(R.string.win_game);
                //gameOver();
            } else {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
                updateQuestion();
            }
        } else {
            for (Button b : answerChoices)
                b.setVisibility(View.GONE);
            v.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
            //v.setBackgroundColor(getResources().getColor(R.color.wrongAnswer));
            //gameOverText.setText(getResources().getText(R.string.wrong_answer));
            //gameOver();
        }
    }
}


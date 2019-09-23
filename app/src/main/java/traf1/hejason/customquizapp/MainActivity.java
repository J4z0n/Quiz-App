package traf1.hejason.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private int highScore = 0;
    Button one,two, three, four, five;
    TextView question, scoreBoard;
    Chronometer cmTimer;
    ArrayList<Question> questionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cmTimer = findViewById(R.id.cmTimer);
        cmTimer.start();

        scoreBoard = findViewById(R.id.score);
        scoreBoard.setText(scoreBoard.getText() + "0");

        question = findViewById(R.id.question);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);

        questionList = read();
        assign();
    }
    public ArrayList<Question> read(){

    }
    public void assign(){
        question.setText(questionList.get(highScore).getQuestion());
        one.setText(questionList.get(highScore).getOne());
        two.setText(questionList.get(highScore).getTwo());
        three.setText(questionList.get(highScore).getThree());
        four.setText(questionList.get(highScore).getFour());
        five.setText(questionList.get(highScore).getFive());
    }
}


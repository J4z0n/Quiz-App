package traf1.hejason.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int highScore;
    Button one,two, three, four;
    TextView textView, scoreBoard;
    Chronometer cmTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cmTimer = findViewById(R.id.cmTimer);
        cmTimer.start();

        scoreBoard = findViewById(R.id.score);
        scoreBoard.setText(scoreBoard.getText() + "0");

    }
}


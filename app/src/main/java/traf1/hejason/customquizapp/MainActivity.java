package traf1.hejason.customquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int highScore;
    Button submitButton,reset;
    EditText nameText, name2Text;
    TextView textView, scoreBoard;
    Chronometer cmTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameText = findViewById(R.id.nameText);
        name2Text = findViewById(R.id.name2Text);
        textView = findViewById(R.id.question);
        cmTimer = findViewById(R.id.cmTimer);
        cmTimer.start();

        scoreBoard = findViewById(R.id.score);
        scoreBoard.setText(scoreBoard.getText() + "0");

        submitButton = findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highScore++;
                scoreBoard.setText("Score: " + highScore);
            }
        });

        reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            reset();
            }

            private void reset() {
                highScore = 0;
                scoreBoard.setText("Score: " + highScore);
                cmTimer.stop();
                cmTimer.setBase(SystemClock.elapsedRealtime());
                cmTimer.start();
            }
        });

        nameText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(nameText.getText().toString().equals("TJ")){
                        textView.setText("TJ Rocks!");
                        nameText.setText("");
                        nameText.setHint("That's a good name");
                    }
                }
            }
        });

        NotificationCompat.Builder builder = new NotificationCompat.Builder()

    }
}

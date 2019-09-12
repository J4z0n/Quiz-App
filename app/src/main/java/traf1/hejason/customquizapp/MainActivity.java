package traf1.hejason.customquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int highScore;
    Button submitButton,reset;
    TextView textView, scoreBoard;
    EditText number1, number2;
    Chronometer cmTimer;
    Spinner dropdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.question);
        cmTimer = findViewById(R.id.cmTimer);
        cmTimer.start();

        scoreBoard = findViewById(R.id.score);
        scoreBoard.setText(scoreBoard.getText() + "0");

        submitButton = findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verify()) {
                    highScore++;
                    scoreBoard.setText("Score: " + highScore);
                }
                else
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

        number1 = findViewById(R.id.FirstNumber);
        number2 = findViewById(R.id.SecondNumber);

        dropdown = findViewById(R.id.operations_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operations_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(SpinnerActivity);

    }
    public class SpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            // An item was selected. You can retrieve the selected item using
            parent.getItemAtPosition(pos);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }

    public int generateNumber(View view){
        return (int)(Math.random() * 100);
    }

    public boolean verify(int result, int number1, int number2, char operation){
        switch (operation){
            case '+':
                return number1 + number2 == result;
            case '-':
                return number1 - number2 == result;
            case '*':
                return number1 * number2 == result;
            case '/':
                return number1 / number2 == result;
            case '%':
                return number1 % number2 == result;
        }
        return false;
    }
    public void toastSomething(View view){
        String text = "Hello world!";
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}


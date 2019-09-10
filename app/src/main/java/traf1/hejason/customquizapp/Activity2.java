package traf1.hejason.customquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {

    Button submit, reset;
    TextView highScore;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        submit = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);
        name = findViewById(R.id.name);
        highScore = findViewById(R.id.score);
    }

    public void displayScores(){
        String text;
        ArrayList<String> scores = new ArrayList<>();
        try{
            InputStream inputStream = getAssets().open("scores.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while((text = bufferedReader.readLine()) != null) {
                scores.add(text);
            }
        }catch(IOException e){}
    }
}



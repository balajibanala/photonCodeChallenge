package com.example.balaji.photoncodechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.balaji.photoncodechallenge.model.ShortestPath;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView displayMatrix;
    TextView displayOutput;

    ShortestPath shortestPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shortestPath = new ShortestPath();

         editText= (EditText) findViewById(R.id.inputString);
         button = (Button) findViewById(R.id.button);
         displayMatrix = (TextView) findViewById(R.id.displayMatrix);
         displayOutput = (TextView) findViewById(R.id.displayOutput);

    }

    public void getShortestRoute(View v){
        displayMatrix.setText(shortestPath.displayMatrix(shortestPath.createMatrix(editText.getText().toString())));
        displayOutput.setText(shortestPath.shortestRoute(editText.getText().toString()));
    }
}

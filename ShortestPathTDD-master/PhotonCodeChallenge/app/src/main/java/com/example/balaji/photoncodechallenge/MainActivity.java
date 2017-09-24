package com.example.balaji.photoncodechallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView displayMatrix;
    TextView displayOutput;

    ShortestRoute shortestRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shortestRoute = new ShortestRoute();

         editText= (EditText) findViewById(R.id.inputString);
         button = (Button) findViewById(R.id.button);
         displayMatrix = (TextView) findViewById(R.id.displayMatrix);
         displayOutput = (TextView) findViewById(R.id.displayOutput);

    }

    public void getShortestRoute(View v){
        String output = shortestRoute.getShortestRoute(editText.getText().toString());
        displayMatrix.setText(shortestRoute.displayMatrix(shortestRoute.getInputMatrix()));
        displayOutput.setText(output);
    }
}

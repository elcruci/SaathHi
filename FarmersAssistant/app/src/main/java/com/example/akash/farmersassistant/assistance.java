package com.example.akash.farmersassistant;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class assistance extends AppCompatActivity {
    TextView textesult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assistance);
        textesult=(TextView) findViewById(R.id.results);

    }

    public void  listen(View view){
                Intent intent =new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault());
                startActivityForResult(intent,10);

                if(intent.resolveActivity((getPackageManager()))!=null){
                    startActivityForResult(intent,10);
                }else {
                    Toast.makeText(this,"Your Device Dont Support Input",Toast.LENGTH_SHORT).show();
                }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10: if(requestCode==RESULT_OK && data!=null){
                  ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                  textResult.setText(result.get(0));
                }
                break;
        }
    }
}
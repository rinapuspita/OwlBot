package com.jiayou.owlbot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jiayou.owlbot.model.OwlBotAdapter;
import com.jiayou.owlbot.model.OwlBotResponse;
import com.jiayou.owlbot.model.Word;
import com.jiayou.owlbot.services.ApiInterface;
import com.jiayou.owlbot.services.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvDict;
    RecyclerView.Adapter mAdapter;
    TextView wordVal, pronounVal, wordJdl, prononJdl;
    EditText wordtxt;
    private ArrayList<OwlBotResponse> list = new ArrayList<>();
    String token = "8bb86a78579537525ab95b8c13831e8136589dd7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvDict = findViewById(R.id.rv_dict);
        wordtxt = findViewById(R.id.txtword);
        wordVal = findViewById(R.id.txtWordv);
        pronounVal = findViewById(R.id.txtpron);
        wordJdl = findViewById(R.id.textView1);
        prononJdl = findViewById(R.id.textView2);
        mAdapter = new OwlBotAdapter(getApplicationContext(), list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvDict.setLayoutManager(layoutManager);
    }

    private void getMoreRecipe(){
        String word = wordtxt.getText().toString();
        cleanData();
        ApiInterface service = ServiceGenerator.createService(ApiInterface.class, "Token "+token);
        Call<Word> call = service.getDictionary(word);
        call.enqueue(new Callback<Word>() {
            @Override
            public void onResponse(Call<Word> call, Response<Word> response) {
                if (response.isSuccessful()) {
//                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, response.body().getWord(), Toast.LENGTH_SHORT).show();
                    wordJdl.setText("Word");
                    prononJdl.setText("Pronunciation");
                    wordVal.setText(response.body().getWord());
                    
                    list = response.body().getDefinitions();
                    for (int i = 0; i < list.size(); i++){
                        OwlBotAdapter adapter = new OwlBotAdapter(MainActivity.this, list);
                        rvDict.setAdapter(adapter);
                    }
                    if (!response.body().getPronunciation().equals("null")){
                        pronounVal.setText("/"+response.body().getPronunciation()+"/");
                    }
                    rvDict.setVisibility(View.VISIBLE);

                } else {
                    Toast.makeText(MainActivity.this, "Sorry, this word didn't match our record.Please check again.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Word> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure load data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void handleBtn(View view) {
        String word = wordtxt.getText().toString();
        if(word.equals("")){
            Toast.makeText(MainActivity.this, "The field can't empty", Toast.LENGTH_SHORT).show();
        } else {
            getMoreRecipe();
        }
    }
    private void cleanData(){
        wordVal.setText("");
        pronounVal.setText("");
        list.clear();
    }
}

package com.tse.baptiste.td1;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NameItemListener{
    private Button buttonNext;
//    private TextView textViewName;
    private RecyclerView recyclerView;


    ListNameAdapter listNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonNext = findViewById(R.id.activity_main_button_next);
//        textViewName = findViewById(R.id.activity_form_plain_text);

        final Context context = this;
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FormActivity.class);

//                startActivityForResult(intent, 0134);
                startActivity(intent);
            }
        });

        listNameAdapter = new ListNameAdapter(this);
        recyclerView = findViewById(R.id.activity_main_recyclerview);
        initList();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == 0134){
//            if(resultCode == RESULT_OK && data.getExtras() != null){
//               Log.d("", "");
//               String name = data.getStringExtra(FormActivity.KEY_USERNAME);
//               textViewName.setText(name);
//            } else {
//                // handle errors
//            }
//        }
//    }

    @Override
    protected void onResume() {
        super.onResume();
//        String name = DataManager.getInstances().getName();
//        textViewName.setText(name);
        List nameList = DataManager.getInstances().getNameList();
        listNameAdapter.updateData(nameList);
    }

    private void initList(){
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listNameAdapter);
    }

    @Override
    public void clickOnItem(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickOnCross(String name) {
        Toast.makeText(this, "cross " + name, Toast.LENGTH_SHORT).show();
    }
}

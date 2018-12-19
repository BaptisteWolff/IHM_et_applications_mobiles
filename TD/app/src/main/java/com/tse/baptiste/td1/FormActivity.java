package com.tse.baptiste.td1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {
    Button buttonSave;
    TextView editTextName;

    public final static String KEY_USERNAME = "key_username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        buttonSave = findViewById(R.id.activity_form_save_button);
        editTextName = findViewById(R.id.activity_form_edit_text);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        String name = editTextName.getText().toString();
        if(!name.isEmpty()){
            DataManager.getInstances().addName(name);
        }
//        Intent resultIntent = new Intent();
//        resultIntent.putExtra(KEY_USERNAME, name);
//        setResult(RESULT_OK, resultIntent);
//        DataManager.getInstances().setName(name);
        finish();
    }
}

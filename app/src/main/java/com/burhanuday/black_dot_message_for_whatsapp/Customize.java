package com.burhanuday.black_dot_message_for_whatsapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Customize extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Button save;
    EditText et_message;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);

        save = findViewById(R.id.btn_save);
        et_message = findViewById(R.id.et_message);

        sharedPreferences = getSharedPreferences("com.burhanuday.black_dot_message_for_whatsapp", MODE_PRIVATE);
        message =sharedPreferences.getString("message", "If you touch the\uD83D\uDC47black point then your whatsapp will hang");


        et_message.setText(message);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("message", et_message.getText().toString()).apply();
                Toast.makeText(Customize.this, "Message Saved", Toast.LENGTH_LONG).show();
            }
        });
    }
}

package com.example.a1811intant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a1811intant.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    static final String KEY = "key1";
    static final int REQUESTCODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivitySecondBinding binding = ActivitySecondBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.GO3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });

        binding.GO1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });

        binding.GOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("key2", "2");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            Toast.makeText(this, "from AC" + data.getStringExtra("key2") + " to AC2", Toast.LENGTH_SHORT).show();
        }
    }
}
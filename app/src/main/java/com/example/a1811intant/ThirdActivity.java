package com.example.a1811intant;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.a1811intant.databinding.ActivityMainBinding;
import com.example.a1811intant.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {

    static final String KEY = "key1";
    static final int REQUESTCODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityThirdBinding binding = ActivityThirdBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.GO2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });

        binding.GO1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });

        binding.GOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("key2", "3");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODE && resultCode == RESULT_OK) {
            Toast.makeText(this, "from AC" + data.getStringExtra("key2") + " to AC3", Toast.LENGTH_SHORT).show();
        }
    }
}
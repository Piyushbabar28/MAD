package com.example.practical;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.b1);
        Button button1 = findViewById(R.id.b2);
        Button button2 = findViewById(R.id.b3);
        Button button3 = findViewById(R.id.b4);
        Button button4 = findViewById(R.id.b5);
        Button button5 = findViewById(R.id.b6);
        Button button6 = findViewById(R.id.b7);
        Button button7 = findViewById(R.id.b8);

        button.setOnClickListener(v -> {
            Intent i= getPackageManager().getLaunchIntentForPackage("com.example.linear");
            startActivity(i);
        });
        button1.setOnClickListener(v -> {
            Intent i= getPackageManager().getLaunchIntentForPackage("com.example.grid");
            startActivity(i);
        });
        button2.setOnClickListener(v -> {
            Intent i= getPackageManager().getLaunchIntentForPackage("com.example.absolute");
            startActivity(i);
        });
        button3.setOnClickListener(v -> {
            Intent i= getPackageManager().getLaunchIntentForPackage("com.example.frame");
            startActivity(i);
        });
        button7.setOnClickListener(v -> {
            Intent i= getPackageManager().getLaunchIntentForPackage("com.example.image2");
            startActivity(i);
        });
        button6.setOnClickListener(v -> {
            Intent i= getPackageManager().getLaunchIntentForPackage("com.example.resume");
            startActivity(i);
        });
        button4.setOnClickListener(v -> {
            Intent i= getPackageManager().getLaunchIntentForPackage("com.example.table");
            startActivity(i);
        });
        button5.setOnClickListener(v -> {
            Intent i= getPackageManager().getLaunchIntentForPackage("com.example.relative");
            startActivity(i);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

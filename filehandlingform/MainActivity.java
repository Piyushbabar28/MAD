package com.example.filehand;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.*;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etId, etPhone, etDept, etClass;
    private TextView tvDisplay;
    private final String FILE_NAME = "mydata.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etPhone = findViewById(R.id.etPhone);
        etDept = findViewById(R.id.etDept);
        etClass = findViewById(R.id.etClass);
        tvDisplay = findViewById(R.id.tvDisplay);

        findViewById(R.id.btnSave).setOnClickListener(v -> saveData());
        findViewById(R.id.btnLoad).setOnClickListener(v -> loadData());
    }

    private void saveData() {
        String data = String.format("Name: %s\nID: %s\nPhone: %s\nDept: %s\nClass: %s\n\n",
                etName.getText(), etId.getText(), etPhone.getText(), etDept.getText(), etClass.getText());

        File file = new File(getExternalFilesDir(null), FILE_NAME);
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write(data.getBytes());
            Toast.makeText(this, "Saved into mydata.txt file!", Toast.LENGTH_SHORT).show();
            clearFields();
        } catch (IOException e) {
            Toast.makeText(this, "Save Failed into mydata.txt file", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadData() {
        File file = new File(getExternalFilesDir(null), FILE_NAME);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) sb.append(line).append("\n");
            tvDisplay.setText(sb.toString());
            Toast.makeText(this, "Loaded into mydata.txt file!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "No data found in mydata.txt", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        etName.setText(""); etId.setText(""); etPhone.setText(""); etDept.setText(""); etClass.setText("");
    }
}

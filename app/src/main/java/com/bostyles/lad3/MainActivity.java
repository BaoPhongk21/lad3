package com.bostyles.lad3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtA, edtB;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ánh xạ View
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Xử lý nút +
        btnAdd.setOnClickListener(v -> tinhToan('+'));

        // Xử lý nút -
        btnSub.setOnClickListener(v -> tinhToan('-'));

        // Xử lý nút *
        btnMul.setOnClickListener(v -> tinhToan('*'));

        // Xử lý nút /
        btnDiv.setOnClickListener(v -> tinhToan('/'));
    }

    // Hàm xử lý tính toán
    private void tinhToan(char phepTinh) {

        if (edtA.getText().toString().isEmpty() ||
                edtB.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ số", Toast.LENGTH_SHORT).show();
            return;
        }

        double a = Double.parseDouble(edtA.getText().toString());
        double b = Double.parseDouble(edtB.getText().toString());
        double kq = 0;

        switch (phepTinh) {
            case '+':
                kq = a + b;
                break;
            case '-':
                kq = a - b;
                break;
            case '*':
                kq = a * b;
                break;
            case '/':
                if (b == 0) {
                    Toast.makeText(this, "Không chia cho 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                kq = a / b;
                break;
        }

        tvResult.setText("Kết quả: " + kq);
    }
}

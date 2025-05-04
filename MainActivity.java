package com.example.k22411caproject2;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText edtCoefficientA;
    EditText edtCoefficientB;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        addViews();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews() {
        edtCoefficientA = findViewById(R.id.edtCoefficientA);
        edtCoefficientB = findViewById(R.id.edtCoefficientB);
        txtResult = findViewById(R.id.txtResult);
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        config.setLayoutDirection(locale);

        resources.updateConfiguration(config, resources.getDisplayMetrics());
        recreate(); // Reload lại Activity để áp dụng ngôn ngữ
    }


    public void do_solution(View view) {
        //để lấy gtr hệ số a:
        String hsa=edtCoefficientA.getText().toString();
        double a=Double.parseDouble(hsa);

        //lấy gtr hs b
        double b=Double.parseDouble(edtCoefficientB.getText().toString());

        if (a==0 && b==0)
        {
            txtResult.setText( getResources().getText(R.string.title_infinity));
        }
        else if (a==0 && b!=0)
        {
            txtResult.setText( getResources().getText(R.string.title_nosolution));
        }
        else
        {
            txtResult.setText("X="+ (-b/a));
        }

    }

    public void do_next(View view) {
        edtCoefficientA.setText("");
        edtCoefficientB.setText("");
        txtResult.setText("");
        //đưa ô nhaapj liệu vào dòng hệ số a nhập cho nhanh
        edtCoefficientA.requestFocus();
    }

    public void do_exit(View view) {
        finish();
    }

    public void changeToEnglish(View view) {
        setLocale("en");
    }

    public void changeToVietnam(View view) {
        setLocale("vi");
    }

    public void changeToFrance(View view) {
        setLocale("fr");
    }

    public void changeToRussian(View view) {
        setLocale("ru");
    }

}
package com.example.lab8_systemanimation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(onClickListener(1));
        button2.setOnClickListener(onClickListener(2));
    }

    private View.OnClickListener onClickListener (final int style) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (style == 1) { buildDialog(R.style.SlideInOut, "Анимация слева направо"); }
                else if (style == 2) { buildDialog(R.style.FadeInOut, "Анимация появления и потухания"); }
            }
        };
    }

    private void buildDialog (int animationSource, String type) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Диалоговое окно");
        builder.setMessage(type);
        builder.setNegativeButton("Окей", null);
        AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = animationSource;
        dialog.show();
    }
}
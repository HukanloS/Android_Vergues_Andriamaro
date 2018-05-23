package org.esiea.vergues_andriamaro.legrandprojet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.esiea.vergues_andriamaro.legrandprojet.R;

public class Gen4Activity extends AppCompatActivity {

    private Button Button4u;
    private Button ButtonXX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen4);

        Button4u = findViewById(R.id.buttonmh4u);
        ButtonXX = findViewById(R.id.buttonmhxx);

        Button4u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Gen4Activity.this,MH4UActivity.class);
                startActivity(intent);
            }
        });
        ButtonXX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Gen4Activity.this,MHXXActivity.class);
                startActivity(intent);
            }
        });
    }
}

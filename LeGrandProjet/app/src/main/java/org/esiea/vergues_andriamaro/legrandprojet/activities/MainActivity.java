package org.esiea.vergues_andriamaro.legrandprojet.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.esiea.vergues_andriamaro.legrandprojet.R;

public class MainActivity extends AppCompatActivity {

    private Button Button1st;
    private Button Button2nd;
    private Button Button3rd;
    private Button Button4th;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button1st = findViewById(R.id.button1);
        Button2nd = findViewById(R.id.button2);
        Button3rd = findViewById(R.id.button3);
        Button4th = findViewById(R.id.button4);

        Button1st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,MHActivity.class);
                startActivity(intent);
            }
        });
        Button2nd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,MHFUActivity.class);
                startActivity(intent);
            }
        });
        Button3rd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,MH3UActivity.class);
                startActivity(intent);
            }
        });
        Button4th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Gen4Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.go_home:
                Toast.makeText(this, "Goodbye", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

 }


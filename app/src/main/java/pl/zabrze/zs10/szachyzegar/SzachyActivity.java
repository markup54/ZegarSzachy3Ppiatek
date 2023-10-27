package pl.zabrze.zs10.szachyzegar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SzachyActivity extends AppCompatActivity {
    Button button;
    TextView textView1, textView2;
    Gracz gracz1, gracz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_szachy);

        button = findViewById(R.id.button4);
        textView1 = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView3);
        gracz1 = new Gracz(true,textView1);
        gracz2 = new Gracz(false,textView2);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        gracz2.startZegar();
                        gracz1.stopZegar();
                    }
                }
        );
    }
}
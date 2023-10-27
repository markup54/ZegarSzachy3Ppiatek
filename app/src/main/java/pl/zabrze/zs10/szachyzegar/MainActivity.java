package pl.zabrze.zs10.szachyzegar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CountDownTimer timer;
    int sekundy =180;
    TextView textView;
    Button buttonStart, buttonStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        buttonStart = findViewById(R.id.button);
        buttonStart.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        timer = new CountDownTimer(sekundy*1000,1000) {
                            @Override
                            public void onTick(long l) {
                                sekundy = (int) l/1000;
                                textView.setText(String.valueOf(sekundy));
                            }

                            @Override
                            public void onFinish() {
                                textView.setText("koniec");
                            }
                        };
                        timer.start();
                    }
                }
        );
        buttonStop = findViewById(R.id.button2);
        buttonStop.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(timer!=null)
                        timer.cancel();
                    }
                }
        );

    }
}
package pl.zabrze.zs10.szachyzegar;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.annotation.ColorRes;

public class Gracz {
    private CountDownTimer timer;
    private int mniejszesekund =1800;
    private boolean dzialajacy;
    private TextView textView;

    public Gracz(boolean dzialajacy,TextView txt) {
        this.dzialajacy = dzialajacy;
        textView = txt;
    }

    public boolean isDzialajacy() {
        return dzialajacy;
    }

    public void setDzialajacy(boolean dzialajacy) {
        this.dzialajacy = dzialajacy;
    }
    public void  stopZegar(){
        dzialajacy = false;
        if(timer!=null){
            timer.cancel();
        }
    }
    public  void startZegar(){
        dzialajacy = true;
        timer = new CountDownTimer(mniejszesekund*100, 100) {
            @Override
            public void onTick(long l) {
                mniejszesekund = (int) l/100;
                wypiszSekundy(mniejszesekund/10);
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
    }
    private void wypiszSekundy(int s){
        int minuty = s/60;
        int sekundy = s%60;
        textView.setText(String.format("%02d : %02d",minuty,sekundy));
        if(s<30) {
            textView.setTextColor(Color.RED);
        }
    }
}
//TODO rozne czasy
//TODO ikona
//TODO wyglad

package pl.zabrze.zs10.szachyzegar;

import android.os.CountDownTimer;
import android.widget.TextView;

public class Gracz {
    private CountDownTimer timer;
    private int sekund =180;
    private boolean dzialajacy;
    private TextView textView;

    public Gracz(boolean dzialajacy) {
        this.dzialajacy = dzialajacy;
    }

    public boolean isDzialajacy() {
        return dzialajacy;
    }

    public void setDzialajacy(boolean dzialajacy) {
        this.dzialajacy = dzialajacy;
    }
    public void  stopZegar(){
        if(timer!=null){
            timer.cancel();
        }
    }
    public  void startZegar(){
        timer = new CountDownTimer(sekund*1000, 1000) {
            @Override
            public void onTick(long l) {
                sekund = (int) l/1000;
                wypiszSekundy(sekund);
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
    }
}

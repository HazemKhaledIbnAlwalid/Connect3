package com.example.android.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int playernum=0;
    boolean f=false;
    int[] empty ={2,2,2,2,2,2,2,2,2};
    int[][] wins={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropIn(View view)
    {
        if(f==false) {
            String s = "";
            ImageView coin = (ImageView) view;
            coin.setTranslationY(-1000f);
            int x = Integer.parseInt(coin.getTag().toString());
            if (empty[x] == 2) {
                empty[x] = playernum;
                if (playernum == 0) {
                    coin.setImageResource(R.drawable.yellow);
                    playernum = 1;
                    s = "Yellow";
                } else {
                    coin.setImageResource(R.drawable.red);
                    playernum = 0;
                    s = "Red";
                }
                coin.animate().translationYBy(1000f).setDuration(300);

                for (int[] wi : wins) {
                    if (empty[wi[0]] == empty[wi[1]] && empty[wi[2]] == empty[wi[1]] && empty[wi[0]] != 2) {
                        (Toast.makeText(getApplicationContext(), s + " Won The Game ", Toast.LENGTH_LONG)).show();
                        f = true;
                    }

                }
                if(f==false) {
                    boolean q = true;
                    for (int i = 0; i < 9; i++)
                        if (empty[i] == 2)
                            q = false;
                    if(q)
                        (Toast.makeText(getApplicationContext(), "It is A Draw ", Toast.LENGTH_LONG)).show();
                }

            }
        }
    }
    public void Renew(View view)
    {
        playernum=0;
        f=false;
        for(int i=0;i<empty.length;i++)
            empty[i]=2;

        GridLayout gl=(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0;i<gl.getChildCount();i++)
        {
            ((ImageView) gl.getChildAt(i)).setImageResource(0);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

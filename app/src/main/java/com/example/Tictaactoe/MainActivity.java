package com.example.Tictaactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    //0: 0,1: X, 2:Empty
    int playerActive=0;
    int gamestate[]={2,2,2,2,2,2,2,2,2};
    public static int count =0 ;
    boolean gameActive = true;

    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


    public void OnImageTap(View view){
        ImageView imageView = (ImageView)view;
        imageView.setTranslationY(-1000);

        int imageTapped = Integer.parseInt(imageView.getTag().toString());
        if(gamestate[imageTapped]==2 && gameActive) {
            count++;
            if(count == 9){
                gameActive= false;
            }
            gamestate[imageTapped]=playerActive;
            if (playerActive == 0) {
                imageView.setImageResource(R.drawable.o);
                playerActive = 1;
                TextView status = findViewById(R.id.textView3);
                status.setText("X's turn ");
            } else {
                imageView.setImageResource(R.drawable.x);
                playerActive = 0;
                TextView status = findViewById(R.id.textView3);
                status.setText("O's turn ");
            }
        }        imageView.animate().translationYBy(1000).setDuration(200);
        int draw= 1;
        for (int[] winningPosition: winningPositions){
            if(gamestate[winningPosition[0]]==gamestate[winningPosition[1]] &&  gamestate[winningPosition[1]]==gamestate[winningPosition[2]]
                    && gamestate[winningPosition[0]] !=2)
            {
                draw =0; //not a draw
                String winner;
                if(gamestate[winningPosition[0]]==0){
                    winner = "0 has won";
                }else {
                    winner ="X has won";
                }
                TextView status =findViewById(R.id.textView3);
                status.setText(winner);

                Button PLAYAGAINBUTTON =findViewById(R.id.button);
                PLAYAGAINBUTTON.setVisibility(View.VISIBLE);
            }
        }
        //DRAW CONDITIONS
        if(count ==9 && draw ==1 ){
            TextView status =findViewById(R.id.textView3);
            status.setText("Match Draw");

            Button PLAYAGAINBUTTON =findViewById(R.id.button);
            PLAYAGAINBUTTON.setVisibility(View.VISIBLE);

        }
    }
    public void PLAYAGAIN(View view) {

        Button PLAYAGAINBUTTON =findViewById(R.id.button);
        PLAYAGAINBUTTON.setVisibility(View.VISIBLE);

        TextView status =findViewById(R.id.textView3);
        status.setText("0's turn");

        gameActive= true;
        playerActive=0;
        count =0;
        for(int i =0 ; i < gamestate.length;i++){
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView1)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView2)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView3)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView4)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView5)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView6)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView7)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageView8)).setImageDrawable(null);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button PLAYAGAINBUTTON =findViewById(R.id.button);
        PLAYAGAINBUTTON.setVisibility(View.INVISIBLE);
    }
}
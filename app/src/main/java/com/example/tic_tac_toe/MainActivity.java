package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //player representation
    //1-X
    //0-O
    int activeplayer=0;
    int gamestate[]={2,2,2 , 2,2,2 , 2,2,2};
    int winpositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTab(View view)
    {
        ImageView img=(ImageView) view;
        int tappedimage=Integer.parseInt(img.getTag().toString());
        if(gamestate[tappedimage]==2)
        {
            TextView status=findViewById(R.id.status);

            gamestate[tappedimage]=activeplayer;
            if(activeplayer==0)
            {
                img.setImageResource(R.drawable.a1);
                activeplayer=1;
                status.setText("Player2's Turn");

            }
            else
            {
                img.setImageResource(R.drawable.a2);
                activeplayer=0;
                status.setText("Player1's Turn");
            }

            for(int winpos[]:winpositions)
            {
                if(gamestate[winpos[0]]==gamestate[winpos[1]] && gamestate[winpos[0]]==gamestate[winpos[2]] && gamestate[winpos[0]]!=2)
                {
                    if(gamestate[winpos[0]]==0)
                    {
                        status.setText("player 1 has won");
                    }
                    else
                        status.setText("player2 has won");

                }
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
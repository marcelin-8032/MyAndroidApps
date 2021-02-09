package com.example.myframeworkapp.game;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myframeworkapp.OptionMenuActivity;
import com.example.myframeworkapp.R;
import com.example.myframeworkapp.game.game1.Game_Main_Activity;
import com.example.myframeworkapp.game.game2.Game2MainActivity;

public class Activity_game_board extends OptionMenuActivity implements View.OnClickListener {


    ImageView imageView_game1, imageView_game2, imageView_game3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        imageView_game1 = findViewById(R.id.imageView_birdgame);
        imageView_game1.setOnClickListener(this);

        imageView_game2 = findViewById(R.id.imageView_tic_toc);
        imageView_game2.setOnClickListener(this);

        imageView_game3 = findViewById(R.id.imageView_ballgame);
        imageView_game3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView_birdgame:
                Intent intentBirdgame = new Intent(Activity_game_board.this, Game_Main_Activity.class);
                startActivity(intentBirdgame);
                break;
            case R.id.imageView_tic_toc:
                Intent intentTicToc = new Intent(Activity_game_board.this, Game2MainActivity.class);
                startActivity(intentTicToc);
                break;
            default:
                break;
        }
    }
}

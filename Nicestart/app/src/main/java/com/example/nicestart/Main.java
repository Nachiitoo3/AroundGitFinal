package com.example.nicestart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button Alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // casting a la vista a la que aplicamos un menu contextual
        // y la registramos
        TextView mycontext = (TextView) findViewById(R.id.textTap);
        registerForContextMenu(mycontext);

        ratingBar = (RatingBar) findViewById(R.id.Puntuacion);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Main.this, "Has votado con " + rating, Toast.LENGTH_LONG).show();
            }
        });

    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.item) {
            Toast toast = Toast.makeText(this, "COPIADO EN PORTAPAPELES",
                    Toast.LENGTH_LONG);
            toast.show();
            return true;
        } else if (item.getItemId()==R.id.action_settings) {
            Toast toast2 = Toast.makeText(this,"DESCARGADO",
                    Toast.LENGTH_LONG );
            toast2.show();
            return true;
        }else
                return super.onContextItemSelected(item);
        }
    }

package com.example.nicestart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

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

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.camera) {
            Toast toast = Toast.makeText(this, "going APPBAR CAMERA", Toast.LENGTH_LONG);
            toast.show();
        }
        return super.onOptionsItemSelected(item);
    }


    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.item) {



              final ConstraintLayout mLayout = findViewById(R.id.MyMainConstraint);

              Snackbar snackbar = Snackbar
                      .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                      .setAction("UNDO", new View.OnClickListener() {
                          @Override
                          public void onClick(View view) {
                              Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                              snackbar1.show();
                        }
                    });
              snackbar.show();

            return true;
        } else if (item.getItemId() == R.id.action_settings) {


            return true;

        } else
//           return super.onContextItemSelected(item);
            return false;
    }
}




package com.example.configureddialogfinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.TypeConverter;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The Si.
     */
    Intent si;
    /**
     * The Adb.
     */
    AlertDialog.Builder adb, /**
     * The Adb 2.
     */
    adb2, /**
     * The Adb 3.
     */
    adb3;
    /**
     * The Colors.
     */
    final String[] colors ={"Red","Green","Blue"};
    /**
     * The Color.
     */
    int color[];
    /**
     * The Linear layout.
     */
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.lin);
        si = new Intent(this,MainActivity2.class);


    }

    /**
     * First.
     *
     * @param view the view
     */
    public void first(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        color = new int[]{0,0,0};
        adb.setTitle("chose one color");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                color[i] = 255;
                linearLayout.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog ad =adb.create();
        ad.show();
    }

    /**
     * Second.
     *
     * @param view the view
     */
    public void second(View view) {
        adb2 = new AlertDialog.Builder(this);
        adb2.setCancelable(false);
        color = new int[]{0,0,0};
        adb2.setTitle("You can choose more than one color");
        adb2.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b) {
                    color[i] = 255;
                }
                else if(color[i]==255){
                    color[i] = 0;
                }
            }
        });
        adb2.setNegativeButton("Cencel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        adb2.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                linearLayout.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });


        AlertDialog ad =adb2.create();
        ad.show();
    }

    /**
     * Third.
     *
     * @param view the view
     */
    public void Third(View view) {
        linearLayout.setBackgroundColor(Color.WHITE);
    }

    /**
     * Fourth.
     *
     * @param view the view
     */
    public void fourth(View view) {
        adb3 = new AlertDialog.Builder(this);
        adb3.setCancelable(false);
        adb3.setTitle("Type here to see magic");
        final EditText eT = new EditText(this);
        eT.setHint("Type text here");
        adb3.setView(eT);
        adb3.setNegativeButton("Cencel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        adb3.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String st = eT.getText().toString();
                Toast.makeText(MainActivity.this,st,Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog ad =adb3.create();
        ad.show();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        String st = menuItem.getTitle().toString();
        if(st.equals("credits")){
            startActivity(si);


        }
        return true;
    }
}
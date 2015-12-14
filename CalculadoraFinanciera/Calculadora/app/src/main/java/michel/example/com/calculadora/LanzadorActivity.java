package michel.example.com.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LanzadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanzador);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }


//    private void inicializarUI () {
//
//        Button btnCalB = (Button) findViewById(R.id.buttonCalB);
//        Button btnCalF = (Button) findViewById(R.id.buttonCalF);
//
//    }
//
    public void LanzadorCalB(View V){

        Intent myIntent = new Intent();
        myIntent.setClass(LanzadorActivity.this,MainActivity.class);
        startActivity(myIntent);
        overridePendingTransition(android.support.v7.appcompat.R.anim.abc_slide_in_bottom,android.support.v7.appcompat.R.anim.abc_slide_out_bottom);

    }public void LanzadorCalF (View V){

        Intent myIntent = new Intent();
        myIntent.setClass(LanzadorActivity.this,CalculadorafinancieraActivity.class);
        startActivity(myIntent);
        overridePendingTransition(android.support.v7.appcompat.R.anim.abc_slide_in_bottom,android.support.v7.appcompat.R.anim.abc_slide_out_bottom);

    }




}

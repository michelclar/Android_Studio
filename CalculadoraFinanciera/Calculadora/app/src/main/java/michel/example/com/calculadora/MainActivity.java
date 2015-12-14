package michel.example.com.calculadora;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText text1, text2;
    TextView textResult;
    float num1, num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarUI();


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void inicializarUI() {
        text1 = (EditText) findViewById(R.id.tex1);
        text2 = (EditText) findViewById(R.id.tex2);

        Button btnSuma = (Button) findViewById(R.id.buttonsuma);
        Button btnResta = (Button) findViewById(R.id.buttonResta);
        Button btnMul = (Button) findViewById(R.id.buttonMul);
        Button btnDiv = (Button) findViewById(R.id.buttonDiv);

        textResult = (TextView) findViewById(R.id.textResul);


    }

    protected boolean ObtenerValor() {

        if (text1.getText().toString().isEmpty() || text2.getText().toString().isEmpty()) {
//         validacion
            Toast.makeText(getApplicationContext(), R.string.Error, Toast.LENGTH_LONG).show();
            return false;

        } else {

            num1 = Float.parseFloat(text1.getText().toString());
            num2 = Float.parseFloat(text2.getText().toString());
            return true;
        }

    }


    public void suma(View V) {
        if (ObtenerValor()) {

            float suma = (num1 + num2);

            textResult.setText("El resultado de la suma es " + Decimal(suma));
        }

    }


    public void resta(View V) {

        if (ObtenerValor()) {
            float resta = num1 - num2;

            textResult.setText("El resultado de la resta es " + Decimal(resta));
        }

    }

    public void Mul(View V) {

        if (ObtenerValor()) {
            float mul = num1 * num2;
            Decimal(mul);
            int m = (int) mul;


            textResult.setText("El resultado de la multiplicacion es " + m);
        }

    }


    public void Div(View V) {

        if (ObtenerValor()) {
            if (num2 != 0) {
                float div = num1 / num2;

                textResult.setText("El resultado de la divicion es " + Decimal(div));
            } else {
                textResult.setText("El resultado de la divicion es ∞");
            }


        }

    }

//  manejo del formato decimales
    public float Decimal(float D) {
        DecimalFormat f = new DecimalFormat("00.000");
        f.format(D);
        return D;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}

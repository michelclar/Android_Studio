package michel.example.com.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class CalculadorafinancieraActivity extends AppCompatActivity {

    Spinner spinner;
    EditText valVe, cuota, interes;
    TextView txtVResult, txtVResultT, txtVCredito;

    float num1, num2, num3, credito, años, cuotaM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadorafinanciera);
        inicializarUI();
        crearSpinner();
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

    public void crearSpinner() {
//      ArrayAdapter para conectar el Spinner a nuestros recursos strings.xml
        ArrayAdapter<CharSequence> adapter;

//      Asignas el origen de datos desde los recursos
        adapter = ArrayAdapter.createFromResource(this, R.array.plazos, android.R.layout.simple_spinner_item);

//      Asignas el layout a inflar para cada elemento
//      al momento de desplegar la lista
//      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//      Seteas el adaptador
        spinner.setAdapter(adapter);
//
//

//        String para llenar el spinner
//        String[] plazo = {"uno","dos","tres","cuatro","cinco","seis", "siete", "ocho"};
////      spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, plazo));
//
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                años = position;
//              (String) adapterView.getItemAtPosition(position)
//                Toast.makeText(adapterView.getContext(), Integer.toString(position), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //nothing
            }

        });


    }

    private void inicializarUI() {


        valVe = (EditText) findViewById(R.id.ValVehiculo);
        cuota = (EditText) findViewById(R.id.Cuota);
        interes = (EditText) findViewById(R.id.TazaInteres);
        spinner = (Spinner) findViewById(R.id.spinner);

        Button btnCalcular = (Button) findViewById(R.id.btnCal);
        Button btnClear = (Button) findViewById(R.id.btnClear);

        txtVCredito = (TextView) findViewById(R.id.textViewCredit);
        txtVResult = (TextView) findViewById(R.id.textViewRes);
        txtVResultT = (TextView) findViewById(R.id.textViewResT);


    }

    protected boolean Validar() {


        if (años == 0) {
            Toast.makeText(getApplicationContext(), R.string.Error, Toast.LENGTH_LONG).show();
            return false;

        }

        if (valVe.getText().toString().isEmpty() || cuota.getText().toString().isEmpty() || interes.getText().toString().isEmpty()) {
//         validacion
            Toast.makeText(getApplicationContext(), R.string.Error, Toast.LENGTH_LONG).show();
            return false;

        } else {

            num1 = Float.parseFloat(valVe.getText().toString());
            num2 = Float.parseFloat(cuota.getText().toString());
            num3 = Float.parseFloat(interes.getText().toString());

            if (num2 > num1) {

                Toast.makeText(getApplicationContext(), R.string.Error2, Toast.LENGTH_LONG).show();
                return false;


            } else {

                if (num3 > 2.19 || num3 <= 0) {

                    Toast.makeText(getApplicationContext(), R.string.Error1, Toast.LENGTH_LONG).show();
                    return false;

                } else {

                    num1 = Float.parseFloat(valVe.getText().toString());
                    num2 = Float.parseFloat(cuota.getText().toString());
                    num3 = Float.parseFloat(interes.getText().toString());
                    return true;


                }


            }


        }

    }


    public void Calcular(View V) {
        if (Validar()) {
//          se calcula el credito
            credito = num1 - num2;
            int a = (int) credito;
            txtVCredito.setText("" + a);
            int c = (int) CalCuotaM(credito, años, num3);
            int ct = CalTotal(años);
            txtVResult.setText("Cuota de crédito de vehículo: " + c);
            txtVResultT.setText("Si el valor de su crédito fue $" + a +
                    ", el pago total que pagará por el préstamo será aproximadamente de $" + ct);

        }

    }

    //   operacion de calculo de cuotas
    protected float CalCuotaM(float cre, float años, float interes) {

        float i = interes / 100;
        float mes = años * 12;
        float m = mes * -1;
        float b = i + 1;

        cuotaM = (float) ((cre * i) / (1 - Math.pow(b, m)));

        return cuotaM;
    }

    protected int CalTotal(float años) {

        int m = (int) (años * 12);
        int c = (int) cuotaM;
        int t = c * m;

        return t;

    }

    public void Clear(View V) {
        valVe.setText("");
        cuota.setText("");
        interes.setText("");
        txtVCredito.setText("");
        txtVResult.setText("");
        txtVResultT.setText("");
        crearSpinner();


    }


}








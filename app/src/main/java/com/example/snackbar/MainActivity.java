package com.example.snackbar;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static com.example.snackbar.R.id.btn1;

/**
 * Aplicación para ver el uso de los snackbar y sus distintas opciones para avisar al usuario.
 * @author Alejandro Mechiné
 * @version 1.0
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mostrar;
    Button cambiar;
    Button padre;
    CoordinatorLayout cLayut;
    LinearLayout lLayut;
    Snackbar snack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrar = (Button) findViewById(btn1);
        mostrar.setOnClickListener(this);
        cambiar = (Button) findViewById(R.id.btn2);
        cambiar.setOnClickListener(this);
        padre = (Button) findViewById(R.id.btn3);
        padre.setOnClickListener(this);

        cLayut = (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
        lLayut = (LinearLayout)findViewById(R.id.partenLinearLayout);



    }

    View.OnClickListener snackbarClickListenner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            snack.dismiss();
        }
    };

    public void onClick(View view){
        switch (view.getId())
        {
            case R.id.btn1:
                Snackbar.make(cLayut, "Mensaje en coorditanor",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.btn2:
                snack = Snackbar.make(cLayut, "Mensaje en otro color",Snackbar.LENGTH_INDEFINITE).setAction("Dismiss", snackbarClickListenner);
                snack.setActionTextColor(Color.RED);
                View view1 = snack.getView();
                // cogemos el color primario oscuro de la actividad.
                view1.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
                snack.show();
                break;
            case R.id.btn3:
                snack = Snackbar.make(lLayut, "Mensaje en linear Layout",Snackbar.LENGTH_INDEFINITE).setAction("Dismiss", snackbarClickListenner);
                snack.setActionTextColor(Color.GREEN);
                View view2 = snack.getView();
                view2.setBackgroundColor(Color.GRAY);
                snack.show();
                break;

        }
    }
}

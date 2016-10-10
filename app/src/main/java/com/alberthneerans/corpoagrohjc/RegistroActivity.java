package com.alberthneerans.corpoagrohjc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    EditText eUsuario,eContrasena,eRcontrasena,eCorreo;
    Button bAceptar,bCancelar;
    private String nombre,contrasena,rcontrasena,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eUsuario=(EditText)findViewById(R.id.eUsuario);
        eContrasena=(EditText) findViewById(R.id.eContrasena);
        eRcontrasena=(EditText) findViewById(R.id.eRcontrasena);//cual es el error que decía?
        //profe ahora no tenia ese error debe serpor algo que borre en el mainactivity.xml lo restauro?
        eCorreo=(EditText) findViewById(R.id.eCorreo);
        bAceptar=(Button) findViewById(R.id.bAceptar);
        bCancelar=(Button) findViewById(R.id.bCancelar);

        bAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                nombre =eUsuario.getText().toString();
                contrasena=eContrasena.getText().toString();
                rcontrasena=eRcontrasena.getText().toString();
                email=eCorreo.getText().toString();

                if(nombre.equals("") || contrasena.equals("") || rcontrasena.equals("") || email.equals("")){
                    Toast.makeText(getApplicationContext(), "Debe digitar todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent=new Intent();
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("contrasena",contrasena);
                    intent.putExtra("email",email);
                    setResult(RESULT_OK, intent);
                    finish();
                }


            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }
}

package com.alberthneerans.corpoagrohjc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogginActivity extends AppCompatActivity {
    EditText eUsuario, eContrasena;
    Button bEntrar;
    TextView tRegistrar;
    private String nombre="",contrasena="",mail="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        eUsuario=(EditText)findViewById(R.id.eUsuario);
        eContrasena=(EditText) findViewById(R.id.eContrasena);
        bEntrar=(Button) findViewById(R.id.bEntrar);
        tRegistrar=(TextView) findViewById(R.id.tRegistro);


        tRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogginActivity.this, RegistroActivity.class);
                startActivityForResult(intent,1234);
            }
        });

        bEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name, password;
                name = eUsuario.getText().toString(); //cargan editext
                password = eContrasena.getText().toString();
                if ((name.equals("") || password.equals(""))) {  //se verifica que no este vacio
                    Toast.makeText(getApplicationContext(), "Digite usuario y contraseña", Toast.LENGTH_SHORT).show();
                } else {
                    if ((nombre.equals(name) && contrasena.equals(password))) {
                        Intent intent = new Intent(LogginActivity.this, MainActivity.class);
                        intent.putExtra("nombre",nombre);
                        intent.putExtra("email",mail);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1234&& resultCode==RESULT_CANCELED){
            Toast.makeText(getApplicationContext(),"Usuario no registrado",Toast.LENGTH_SHORT).show();
        }else{
            if(requestCode==1234&& resultCode==RESULT_OK){
                nombre=data.getExtras().getString("nombre");
                contrasena=data.getExtras().getString("contrasena");
                mail=data.getExtras().getString("email");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

package com.example.elicop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.example.elicop.R;

public class act_login extends AppCompatActivity {

    TextInputEditText edtContra, edtUser;
    String contra, user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_login);
        edtContra = (TextInputEditText) findViewById(R.id.edtContra);
        edtUser =(TextInputEditText) findViewById(R.id.edtUser);
        Intent intent = getIntent();
        contra = intent.getStringExtra("contra");
        user = intent.getStringExtra("user");
    }

    public void validarInicio(View view){
        String usuarioIngresado = edtUser.getText().toString().trim();
        String contraIngresado = edtContra.getText().toString().trim();

        if(usuarioIngresado.equals("")&&contraIngresado.equals("")){
            //Toast.makeText(this, "ERROR Campos vacios", Toast.LENGTH_LONG).show();
            toastIncorrecto("ERROR Campos vacios");
        }else if((usuarioIngresado.equals("prueba")&&contraIngresado.equals("123")) || (usuarioIngresado.equals(user)&&contraIngresado.equals(contra))){

            Intent main = new Intent(act_login.this,MainActivity.class);
            startActivity(main);
            toastCorrecto("Excelente, Datos Correctos Haz Iniciado Sesión ");
            finish();
        }else{
            //Toast.makeText(this, "Dni y/o Password incorrectos", Toast.LENGTH_LONG).show();
            toastIncorrecto("Credenciales Inválidas, usuario y/o Password incorrectos");
        }
    }

    public void registrarmeOnClick(View view) {
        Intent intent = new Intent(act_login.this, act_registro.class);

        startActivity(intent);
    }

    public void toastCorrecto(String msg) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_toast_ok, (ViewGroup) findViewById(R.id.ll_custom_toast_ok));
        TextView txtMensaje = view.findViewById(R.id.txtMensajeToast1);
        txtMensaje.setText(msg);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

    public void toastIncorrecto(String msg) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custom_toast_error, (ViewGroup) findViewById(R.id.ll_custom_toast_error));
        TextView txtMensaje = view.findViewById(R.id.txtMensajeToast2);
        txtMensaje.setText(msg);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }

}

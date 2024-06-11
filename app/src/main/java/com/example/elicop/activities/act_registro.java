package com.example.elicop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.elicop.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

public class act_registro extends AppCompatActivity {

    TextInputEditText edtContra, edtContra2, edtEmail, edtUser;
    String contraV, contra2, email, userV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lyt_registro);
        asignarReferencia();

    }

    private void asignarReferencia() {
        edtUser = (TextInputEditText)findViewById(R.id.edtUser);
        edtEmail = (TextInputEditText)findViewById(R.id.edtEmailUser);
        edtContra =(TextInputEditText) findViewById(R.id.edtContra);
        edtContra2 =(TextInputEditText) findViewById(R.id.edtContra2);


    }


    public void registrar(View view){
        String contra, contra2, email, user;
        user = edtUser.getText().toString().trim();
        email = edtEmail.getText().toString().trim();
        contra = edtContra.getText().toString().trim();
        contra2 = edtContra2.getText().toString().trim();

        if(!contra.equals("")&&!contra2.equals("")&&!user.equals("")&&!email.equals("")){
            if(contra.equals(contra2)){
                boolean a = esNombreValido(user);
                boolean c = esCorreoValido(email);

                userV=user;
                contraV=contra;
                toastCorrecto("Registro Exitoso!!!");



            }else{
                //Toast.makeText(this, "Las contraseñas deben coincidir", Toast.LENGTH_LONG).show();
                toastIncorrecto("IMPORTANTE, Las contraseñas deben coincidir");
            }
        }else{
        //Toast.makeText(this, "Las contraseñas deben coincidir", Toast.LENGTH_LONG).show();
        toastIncorrecto("IMPORTANTE, Completa el formulario");
    }
    }

    private boolean esNombreValido(String nombre) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(nombre).matches() || nombre.length() > 30) {
            edtUser.setError("Nombre inválido");
            return false;
        } else {
            edtUser.setError(null);
        }

        return true;
    }

    private boolean esCorreoValido(String correo) {
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            edtEmail.setError("Correo electrónico inválido");
            return false;
        } else {
            edtEmail.setError(null);
        }

        return true;
    }

    public void IniciarSesion(View view){
        Intent intent = new Intent(this, act_login.class);
        intent.putExtra("contra", contraV);
        intent.putExtra("user", userV);
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

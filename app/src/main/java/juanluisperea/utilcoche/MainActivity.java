package juanluisperea.utilcoche;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import juanluisperea.utilcoche.Modelos.Coche;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Context context = this;

    Button buttonRegister, buttonSignIn;
    EditText editTextEmail, editTextPass;

    FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRegister = (Button) findViewById(R.id.registbtn);
        buttonSignIn = (Button) findViewById(R.id.loginbtn);
        editTextEmail = (EditText) findViewById(R.id.usuario);
        editTextPass = (EditText) findViewById(R.id.password);

        buttonRegister.setOnClickListener(this);
        buttonSignIn.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Log.i("SESION" , "sesion iniciada con mail " + user.getEmail() );
                    Toast.makeText(context, "Sesión iniciada con mail: " + user.getEmail(), Toast.LENGTH_LONG).show();
                    iniciar();
                }
                else {
                    Log.i("SESION" , "Sesion Cerrada");
                }
            }


        };

    }


    private void registrar(String email, String pass){

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    /*
                    // Cuando el usuario se registra, se crea una entrada nueva en Firebase con el id del usuario
                    Map<String, String> nuevoUsuario = new HashMap<String, String>();
                    nuevoUsuario.put(user.getUid(), "idUsuario");
                    database.getReference().child("utilcoche").setValue(nuevoUsuario);
                    */

                    Toast.makeText(context, "Usuario Creado Correctamente", Toast.LENGTH_LONG).show();
                    iniciar();
                }
                else
                {
                    Log.e("SESION", task.getException().getMessage() + "");
                    Toast.makeText(context, "No se pudo crear el usuario, por favor revisar datos. " + task.getException().getMessage()  , Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void iniciarSesion(String email, String pass){

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.i("SESION", "Sesion Iniciada");
                    iniciar();
                }
                else
                {
                    Log.e("SESION", task.getException().getMessage() + "");
                    Toast.makeText(context, "Usuario o contraseña incorrectos, por favor revisar datos. "  , Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.loginbtn:
                String emailInicio = editTextEmail.getText().toString();
                String passInicio = editTextPass.getText().toString();
                iniciarSesion(emailInicio, passInicio);
                break;

            case R.id.registbtn:
                String emailReg = editTextEmail.getText().toString();
                String passReg = editTextPass.getText().toString();
                registrar(emailReg, passReg);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mAuthListener != null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);

        }
    }

    public void iniciar(){
        Intent i = new Intent(this, ListaCochesActivity.class );
        startActivity(i);
    }

}

package juanluisperea.utilcoche;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import juanluisperea.utilcoche.Adapters.CochesAdapter;
import juanluisperea.utilcoche.Modelos.Coche;

public class ListaCochesActivity extends AppCompatActivity {

    RecyclerView rv;
    List<Coche> coches;
    CochesAdapter cochesAdapter;
    FirebaseDatabase database;
    FirebaseUser user;
    FirebaseAuth.AuthStateListener mAuthListener;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_coches);

        rv = (RecyclerView)findViewById(R.id.recyclercoches);

        rv.setLayoutManager(new LinearLayoutManager(this));

        coches = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        cochesAdapter = new CochesAdapter(context, coches);

        rv.setAdapter(cochesAdapter);

        user = FirebaseAuth.getInstance().getCurrentUser();

        // Listener que actualiza el RecyclerView automáticamente conectado a Firebase
        // Muestra los datos del usuario que está autenticado
        database.getReference().child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                coches.removeAll(coches);
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Coche coche = snapshot.getValue(Coche.class);
                    coches.add(coche);
                }
                cochesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        // Listener por si hay un cambio en la autenticación del usuario
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null){

                }
                else {
                    Log.i("SESION" , "Sesion Cerrada");
                }
            }


        };

    }

    public void nuevoCoche (View v){

        Intent i = new Intent(this, AltaCoche.class );
        startActivity(i);

    }


}

package juanluisperea.utilcoche;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import juanluisperea.utilcoche.Modelos.Coche;

public class AltaCoche extends AppCompatActivity {

    FirebaseDatabase database;
    FirebaseUser user;
    List<Coche> coches;

    ImageView fotocoche;
    EditText nombrecoche;
    EditText combustible;
    EditText kms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_coche);

        fotocoche = (ImageView)findViewById(R.id.fotocoche);
        nombrecoche = (EditText)findViewById(R.id.nombrecochenuevo);
        combustible = (EditText)findViewById(R.id.combustiblecochenuevo);
        kms = (EditText)findViewById(R.id.kmscochenuevo);

        database = FirebaseDatabase.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();

        coches = new ArrayList<>();

        // Listener que actualizala lista de coches conectado a Firebase
        // Muestra los datos del usuario que está autenticado
        database.getReference().child(user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                coches.removeAll(coches);
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Coche coche = snapshot.getValue(Coche.class);
                    coches.add(coche);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


    public void crearnuevocoche(View v){

        Random rnd = new Random();
        // reconstruimos la lista de coches y le añadimos el nuevo y lo ponemos en un Map
        Map<String, Object> garaje = new HashMap<String, Object>();
        for(Coche lista : coches){
            garaje.put("" + rnd.nextInt(), lista);
        }
        //garaje.put("" + rnd.nextInt(), new Coche(1, "Opel Astra", "Diesel", rnd.nextInt(100000), "01/04/2017"));
        Calendar calendario = Calendar.getInstance();
        String hoy = calendario.get(Calendar.DAY_OF_MONTH) + "/" + calendario.get(Calendar.MONTH) + "/" + calendario.get(Calendar.YEAR);
        garaje.put(nombrecoche.getText().toString(), new Coche(1, nombrecoche.getText().toString(), combustible.getText().toString(), Integer.parseInt(kms.getText().toString()), hoy ));

        // usamos setValue porque updateChildren no hace la conversion a JSON y da error sin parsearlo
        // setValue hace la conversión él mismo y no da error
        DatabaseReference nodoUsuario = database.getReference().child(user.getUid());
        nodoUsuario.setValue(garaje);


        Intent i = new Intent(this, ListaCochesActivity.class );
        startActivity(i);

    }
}

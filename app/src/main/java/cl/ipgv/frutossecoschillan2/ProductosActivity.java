package cl.ipgv.frutossecoschillan2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class ProductosActivity extends AppCompatActivity {

    private ListView listViewProductos;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos); // Crea este layout

        listViewProductos = findViewById(R.id.listViewProductos);
        databaseReference = FirebaseDatabase.getInstance().getReference("productos");

        loadProductos();
    }

    private void loadProductos() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<String> productos = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Producto producto = snapshot.getValue(Producto.class);
                    if (producto != null) {
                        productos.add(producto.getNombre() + " - $" + producto.getPrecio());
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(ProductosActivity.this, android.R.layout.simple_list_item_1, productos);
                listViewProductos.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Manejo de errores
            }
        });
    }
}

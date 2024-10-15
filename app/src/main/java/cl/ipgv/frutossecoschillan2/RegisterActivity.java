package cl.ipgv.frutossecoschillan2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonRegister;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        databaseReference = FirebaseDatabase.getInstance().getReference("usuarios");

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String nombre = editTextNombre.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        String userId = databaseReference.push().getKey();
        Usuario usuario = new Usuario(nombre, email, password);
        if (userId != null) {
            databaseReference.child(userId).setValue(usuario)
                    .addOnSuccessListener(aVoid -> Toast.makeText(RegisterActivity.this, "Usuario registrado", Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e -> Toast.makeText(RegisterActivity.this, "Error al registrar: " + e.getMessage(), Toast.LENGTH_SHORT).show());
        }
    }
}

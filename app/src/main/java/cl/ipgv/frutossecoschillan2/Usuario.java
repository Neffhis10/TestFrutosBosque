package cl.ipgv.frutossecoschillan2;

public class Usuario {
    private String nombre;
    private String email;
    private String password;

    public Usuario() {
        // Constructor vacío necesario para Firebase
    }

    public Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

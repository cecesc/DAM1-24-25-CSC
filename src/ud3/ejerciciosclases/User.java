/*Implementa la clase User con las siguientes especificaciones:
Atributos privados para almacenar:
username, password, email como cadenas de caracteres.
createdAt, lastLogin, como LocalDateTime.
enabled como boolean.
Un constructor que acepte username, password, email y enabled y que inicializará el atributo createdAt al valor del momento actual. 
Un constructor que acepte username y password y cree un usuario activo, en la fecha actual, y con email igual a null.
Un constructor como el anterior pero que acepte sólo el username y lo cree con sin contraseña (igual a null).

Sobreescribe (overrride) el método toString() para que al imprimir un objeto de clase User imprima el valor de su atributo username.*/

package ud3.ejerciciosclases;

import java.time.LocalDateTime;

public class User {
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
    private boolean enabled;

    public User(String username, String password, String email, boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = LocalDateTime.now();
        this.enabled = enabled;
    }

    public User(String username, String password) {
        this(username, password, null, true);
    }

    public User(String username) {
        this(username, null, null, true);
    }

    @Override
    public String toString() {
        return username;
    }
}

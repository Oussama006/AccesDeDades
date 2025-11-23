public class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    String nom;
    String password;
    
    public User(String oussama, String string) {
        this.nom = oussama;
        this.password = string;
    }
}
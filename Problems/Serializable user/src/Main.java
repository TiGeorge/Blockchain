import java.io.Serializable;

class User implements Serializable {
    String name;
    transient String password;
    public static final long serialVersionUID = 1L;
}
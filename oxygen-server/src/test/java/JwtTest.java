import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class JwtTest {

    public static String getPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

        String res = bCryptPasswordEncoder.encode(password);

        return res;
    }

    public static void main(String[] args) {
        String pw = "134679nb";

        System.out.println(getPassword(pw));
    }
}

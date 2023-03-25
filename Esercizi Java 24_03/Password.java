import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Console;

public class Password {

    public static void main(String[] args) {

        // - ha almeno 8 caratteri
        // - ha almento un numero
        // - ha almeno un carattere in stampatello
        // - extra: contiene un carattere speciale "!", "£", "$", "%", "&"

        Console cons = System.console();
        String password = new String(cons.readPassword("%s", "Inserisci la password: "));

        if(passwordCheck(password)) System.out.println("\nPassword corretta");
        else System.out.println("\nPassword non corretta");
        
    }

    public static boolean passwordCheck(String string) {
        
        if(!(string.length() >= 8)) {
            
            System.out.println("La password non è lunga almeno 8 caratteri.");
            return false;
            
        }
       
        boolean upperCase = false;
        boolean number = false;
        Pattern special = Pattern.compile ("[!£$%&]");
        Matcher hasSpecial = special.matcher(string);
        boolean boolSpecial = hasSpecial.find();

        for (int i = 0; i < string.length(); i++) {

            if(Character.isDigit(string.charAt(i))) number = true;
            if(Character.isUpperCase(string.charAt(i))) upperCase = true;
            
        }

        if(!upperCase) System.out.println("La password non contiene un carattere in stampatello.");
        if(!number) System.out.println("La password non contiene un numero.");
        if(!boolSpecial) System.out.println("La password non contiene un carattere speciale.");

        return string.length() >= 8 && upperCase && number && boolSpecial;
    
    }
}

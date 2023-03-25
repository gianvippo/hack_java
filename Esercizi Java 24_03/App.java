/**
 * App
 */
public class App {

    public static void main(String[] args) {
        System.out.println("hello world");

        Taglie taglia = Taglie.SMALL;

        System.out.println("taglia: " + taglia);

        var num = 5;
        int numCast = (int) num;

        String stringa = new String("stringa");

        System.out.println("numero castato: " + numCast);

        System.out.println("Stringa: " + stringa );

        System.out.println("lunghezza argomenti passati: " + args.length);  // java App "A" "B" "C"

    }

    enum Taglie { SMALL, LARGE, XLARGE }
}
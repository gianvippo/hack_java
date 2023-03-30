public class App {
    public static void main(String[] args) throws Exception {

        // qui generiamo una classe con parametro String
        GenericClass<String> gen = new GenericClass<String>("Not so generic");
        System.out.println(gen.getData());

        // qui generiamo una classe con parametro Integer
        GenericClass<Integer> integer = new GenericClass<Integer>(12);
        System.out.println(integer.getData());

        GenericClassWithoutT gen1 = new GenericClassWithoutT();
        gen1.<String>print("Ciao");

        System.out.println(gen1.<String>returnTypeGeneric("Ciaone"));

        // vogliamo generare una classe che identifichi una coppia di valori
        // coppie di stringhe, interi etc...

        Pair<String> p1 = new Pair<String>("Ciao", "Java");
        System.out.println(p1.getParam1() + " : " + p1.getParam2());

        Pair<Integer> p2 = new Pair<Integer>(5, 6);
        System.out.println(p2.getParam1() + " : " + p2.getParam2());


        PairMoreGeneric<String, Integer> genp1 = new PairMoreGeneric<String, Integer>("Ciao", 6);
        System.out.println(genp1.getParam1() + " : " + genp1.getParam2());

        System.out.println(genp1.<Boolean>returnSomething(true));


        // algoritmi per array
        String[] nomi = new String[] {"Antonio", "Giuseppe", "Zoe", "Franco", "Pasquale"};
        String nomeMinimo = AlgoForArrays.<String>min(nomi);
        String nomeMassimo = AlgoForArrays.<String>max(nomi);
        System.out.println("Il nome minimo è " + nomeMinimo);
        System.out.println("Il nome massimo è " + nomeMassimo);


        Integer[] numeri = new Integer[] {10,25,30,2,50,82};
        int numeroMinimo = AlgoForArrays.<Integer>min(numeri);
        int numeroMassimo = AlgoForArrays.<Integer>max(numeri);
        System.out.println("Il numero minimo è " + numeroMinimo);
        System.out.println("Il numero massimo è " + numeroMassimo);


    }
}

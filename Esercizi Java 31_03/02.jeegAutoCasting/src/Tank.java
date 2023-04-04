public class Tank extends Moveable implements CanAttack{

    @Override
    public void attacca() {
        System.out.println("Sparo un missile con il tank");
    }

    @Override
    void muovitiInAvanti() {
        System.out.println("Rotolo in avanti");
    }

    @Override
    void muovitiIndietro() {
        System.out.println("Rotolo indietro");
    }
    
}

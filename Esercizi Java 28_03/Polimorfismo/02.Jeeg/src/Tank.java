public class Tank extends Moveable implements canAttack{

    @Override
    public void goForward() {
        System.out.println("Mi muovo in avanti con i cingoli.");
        
    }

    @Override
    public void goBack() {
        System.out.println("Mi muovo indietro con i cingoli.");
    }

    @Override
    public void attacca() {
        System.out.println("Ti sparo con il tank.");
    }
    
}

public abstract class Arm implements CanAttack{

    protected String sideLabel;

    public Arm(String sideLabel) {
        this.sideLabel = sideLabel;
    }

    @Override
    public abstract void attacca();
    
}

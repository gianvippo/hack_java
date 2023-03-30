public class Jeeg {
    
    private Arm armDx;
    private Arm armSx;
    private Moveable moveable;

    public Jeeg(Arm armDx, Arm armSx, Moveable moveable) {
        this.armDx = armDx;
        this.armSx = armSx;
        this.moveable = moveable;
    }

    public void attacca() {
        this.armDx.attacca();
        this.armSx.attacca();
        this.armSx.attacca();
        this.armDx.attacca();
        Class<? extends Object> classe = this.moveable.getClass();
        if (classe.toString().equals("class Tank")) {
            // fino a questo punto, anche se io passo un tank, ho comunque un oggetto di classe Moveable che non implementa attacca()
            // Quindi, se entro nell'if, SO SICURAMENTE che in this.moveable c'è un Tank
            // QUINDI POSSO CASTARLO IN UN TANK
            Tank t = (Tank) this.moveable;
            t.attacca();
        }
    }

    public void goForward() {
        this.moveable.goForward();
    }

    public void goBack() {
        this.moveable.goBack();
    }
    
}

public class Jeeg {

    private Arm armDx;
    private Arm amrSx;
    private Moveable moveable;
    
    public Jeeg(Arm armDx, Arm amrSx, Moveable moveable) {
        setArm(armDx, Side.Dx);
        setArm(amrSx, Side.Sx);
        setMoveable(moveable);
    }

    public Arm getArmDx() {
        return armDx;
    }
    
    public Arm getAmrSx() {
        return amrSx;
    } 

    public void setArm(Arm newArm, Side side) {
        if(side == Side.Sx) this.amrSx = newArm;
        else this.armDx = newArm;
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    public void attacca(){
        this.armDx.attacca();
        this.amrSx.attacca();
        this.amrSx.attacca();
        this.armDx.attacca();
        if(this.moveable instanceof Tank){
            Tank t = (Tank) moveable;
            t.attacca();
        }
    }

    public void muovitiInAvanti(){
        this.moveable.muovitiInAvanti();
    }
    public void muovitiIndietro(){
        this.moveable.muovitiIndietro();
    }
    
}

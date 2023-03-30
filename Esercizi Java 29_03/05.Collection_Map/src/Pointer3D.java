public class Pointer3D {
    public int x;
    public int y;
    public int z;

    public Pointer3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getZ() {
        return z;
    }
    public void setZ(int z) {
        this.z = z;
    }

    public void print() {
        System.out.println("x: " + x + " y: " + y + " z: " + z);
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Pointer3D){   // se sono della stessa classe
            Pointer3D other = (Pointer3D) obj;
            return x == other.x && y == other.y && z == other.z;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return x + y + z;
    }
}

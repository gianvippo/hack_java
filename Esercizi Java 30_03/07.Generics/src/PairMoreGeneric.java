public class PairMoreGeneric<T1, T2> {
    
    private T1 param1;
    private T2 param2;

    public PairMoreGeneric(T1 param1, T2 param2) {
        this.param1 = param1;
        this.param2 = param2;
    }
    
    public T1 getParam1() {
        return param1;
    }
    public void setParam1(T1 param1) {
        this.param1 = param1;
    }
    public T2 getParam2() {
        return param2;
    }
    public void setParam2(T2 param2) {
        this.param2 = param2;
    }

    public <T3> T2 returnSomething(T3 param){
        return param2;
    }
}

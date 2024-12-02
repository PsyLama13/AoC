package y2021.d4;

public class BingoValue{
    private int value;
    private boolean marked;
    public BingoValue(int value){
        this.value = value;
        this.marked = false;
    }

    public void markValue(){
        this.marked = true;
    }

    public int value(){
        return value;
    }

    public boolean marked(){
        return marked;
    }

    @Override
    public String toString(){
        return value + " " + marked;
    }

}

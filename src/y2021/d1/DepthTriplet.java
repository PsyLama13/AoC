package y2021.d1;

public record DepthTriplet(int a, int b, int c) {

    int getSum(){
        return a+b+c;
    }
}

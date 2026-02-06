package challenges.year2019.day01;

public class Module {
    int mass;

    public Module(int mass) {
        this.mass = mass;
    }

    public int getFuel() {
        return mass / 3 - 2;
    }

    public int getFuel(int massToCalculate) {
        return massToCalculate / 3 - 2;
    }

    public int getExtendedFuel() {
        int tempFuel = 0;
        int tempMass = mass;
        while (true) {
            int a = getFuel(tempMass);
            if (a <= 0) {
                break;
            }
            tempFuel += a;
            tempMass = a;
        }
        return tempFuel;
    }
}
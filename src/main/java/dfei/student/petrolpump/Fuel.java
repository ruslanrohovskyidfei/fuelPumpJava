package dfei.student.petrolpump;

public class Fuel {
    private double fuelAmount;

    Fuel() {
        this.fuelAmount = 0;
    }
    Fuel(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
    public double getFuelAmount() {
        return this.fuelAmount;
    }
}

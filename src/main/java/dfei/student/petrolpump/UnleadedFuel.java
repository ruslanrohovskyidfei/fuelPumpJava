package dfei.student.petrolpump;

public class UnleadedFuel extends Fuel{
    private double unleadedFuelAmount;

    UnleadedFuel() {
        this.unleadedFuelAmount = 0;
    }
    UnleadedFuel(double unleadedFuelAmount) {
        this.unleadedFuelAmount = unleadedFuelAmount;
    }
    public void setFuelAmount(double fuelAmount) {
        this.unleadedFuelAmount = fuelAmount;
    }
    public double getFuelAmount() {
        return this.unleadedFuelAmount;
    }
}

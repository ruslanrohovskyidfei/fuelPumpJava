package dfei.student.petrolpump;

public class LeadedFuel extends Fuel {
   private double leadedFuelAmount;

   LeadedFuel() {
       this.leadedFuelAmount = 0;
   }
    LeadedFuel(double leadedFuelAmount) {
        this.leadedFuelAmount = leadedFuelAmount;
    }
    public void setFuelAmount(double fuelAmount) {
        this.leadedFuelAmount = fuelAmount;
    }
    public double getFuelAmount() {
        return this.leadedFuelAmount;
    }
}

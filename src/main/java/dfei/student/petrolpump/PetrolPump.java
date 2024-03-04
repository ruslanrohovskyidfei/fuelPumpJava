/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package dfei.student.petrolpump;
import java.text.NumberFormat;
/**
 *
 * @author 20231437
 */
public class PetrolPump {
    private double petrolPrice;
    private double currentPetrol;
    private double minLevelPetrol;
    private String petrolType;
    
    public PetrolPump() {
        this.petrolPrice = 0;
        this.currentPetrol = 0;
        this.minLevelPetrol = 0;
        this.petrolType = "";
    }
    public PetrolPump(double petrolPrice, double currentPetrol, double minLevelPetrol, String petrolType) {
        this.petrolPrice = petrolPrice;
        this.currentPetrol = currentPetrol;
        this.minLevelPetrol = minLevelPetrol;
        this.petrolType = petrolType;
    }
    public double fillCarFromPump(double givenPetrol) {
        double finalPrice = 0;
        if (this.currentPetrol - givenPetrol >= minLevelPetrol) {           
            this.currentPetrol -= givenPetrol;
            finalPrice = givenPetrol * this.petrolPrice;
        }        
        return finalPrice;
    }
    public void addFuel(double addPetrol) {
        this.currentPetrol += addPetrol;
    }
    
    public double getPetrolPrice() {
        return this.petrolPrice;
    }
    
    public double currentPetrol() {
        return this.currentPetrol;
    }
    
    public double minLevelPetrol() {
        return this.minLevelPetrol;
    }
    
    public String petrolType() {
        return this.petrolType;
    }
    
    public void setPetrolPrice(double PetrolPrice) {
        this.petrolPrice = PetrolPrice;
    }
    
    public void setMinLevelPetrol(double minLevelPetrol) {
        this.minLevelPetrol = minLevelPetrol;
    }
    
    public static void main(String[] args) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        
        double operationPrice = 0;
        PetrolPump todayPump = new PetrolPump(0.75, 20000, 2, "Unleaded");
        operationPrice = todayPump.fillCarFromPump(25);
        //Operation price output
        System.out.println(currencyFormatter.format(operationPrice));
    }
}
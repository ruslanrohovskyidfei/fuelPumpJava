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
    private double currentPetrolLevel;
    private double minPetrolLevel;
    private String petrolType;
    
    //Constructor
    public PetrolPump() {
        this.petrolPrice = 0;
        this.currentPetrolLevel = 0;
        this.minPetrolLevel = 0;
        this.petrolType = "";
    }
    //Overloaded Constructor
    public PetrolPump(double petrolPrice, double currentPetrol, double minLevelPetrol, String petrolType) {
        this.petrolPrice = petrolPrice;
        this.currentPetrolLevel = currentPetrol;
        this.minPetrolLevel = minLevelPetrol;
        this.petrolType = petrolType;
    }
    public double fillCarFromPump(int givenPetrol) {
        double finalPrice = 0;
        String message;        
        if(this.checkPumpStayFilled(givenPetrol) && this.checkPumpAmount(givenPetrol)) {            
            this.currentPetrolLevel -= givenPetrol;
            finalPrice = givenPetrol * this.petrolPrice;
            message = "You need to pay " +  formatPrice(finalPrice) + " for " + givenPetrol + " litres of Fuel";
        } else {
            message = "Pump is not having those amount of Fuel";
        }
        System.out.print(message);
        return finalPrice;
    }
    public boolean checkPumpStayFilled(int givenPetrol) {       
        boolean status = false;
        
        if (this.currentPetrolLevel - givenPetrol >= minPetrolLevel) {           
            status = true;
        }
        return status;
    }
    public boolean checkPumpAmount(int givenPetrol) {       
        boolean status = false;
        
        if (this.currentPetrolLevel > givenPetrol) {           
            status = true;
        } 
        return status;
    }
    public void addFuel(double addPetrol) {
        this.currentPetrolLevel += addPetrol;
    }
    
    public double getPetrolPrice() {
        return this.petrolPrice;
    }    
    
    public void setPetrolPrice(double PetrolPrice) {
        this.petrolPrice = PetrolPrice;
    }
    
    public void setMinLevelPetrol(double minLevelPetrol) {
        this.minPetrolLevel = minLevelPetrol;
    }
    
    
    public double getMinLevelPetrol() {
        return this.minPetrolLevel;
    }
    
    public double currentPetrolLevel() {
        return this.currentPetrolLevel;
    }
    
    public String petrolType() {
        return this.petrolType;
    }
    
    public String formatPrice(double price) {
        //Declare price formatter
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        
        //Operation price output
        System.out.println(currencyFormatter.format(price));
        
        return currencyFormatter.format(price);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package dfei.student.petrolpump;
import java.text.NumberFormat;
import java.util.Scanner;
/**
 *
 * @author 20231437
 */
public class PetrolPump {
    private double petrolPrice;
    private double currentPetrolLevel;
    private double minPetrolLevel;
    private String petrolType;

    //Initializing Input/Output
    private Scanner Input = new Scanner(System.in);  
    
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

    public void printSeparator() {
        System.out.println("**********");
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

    public double availablePetrolLevel() {
        return this.currentPetrolLevel - this.minPetrolLevel;
    }

    public String petrolType() {
        return this.petrolType;
    }

    public void fillCarFromPump(double givenPetrol) {
        double finalPrice;     
        
        //Make calculation in the Pump
        this.currentPetrolLevel -= givenPetrol;
        finalPrice = givenPetrol * this.petrolPrice;
        if(this.useATM(finalPrice, givenPetrol)) {               
            this.printSeparator();
            try { 
                long numMillisecondsToSleep = 1500; // 5 seconds 
                Thread.sleep(numMillisecondsToSleep);                 
            } catch (InterruptedException e) {                          
                 System.out.println("Something wrong with Pump, ask manager for help!");
            } 
            System.out.println("Fueling finished");
            this.printSeparator();
            System.out.println("Amount of " + this.petrolType + " petrol left in a pump after fueling: " + this.availablePetrolLevel());
        }
    }
    public boolean useATM(double price, double givenPetrol) {
        boolean status = false;         
        
        //Declare input variable
        double money = 0;
        //Show message about succesful purchase with amount of Litres and Price  
        this.printSeparator();
        System.out.println("You need to pay " +  formatPrice(price) + " for " + givenPetrol + " litres of Fuel");
        //Input customer data
        while(money == 0) {                 
            System.out.print("Pay " + formatPrice(price) + " for your fueling: ");    
            try {
                money = Double.parseDouble(this.Input.next());
            } catch(NumberFormatException e) {
                System.out.println("We accept only £, $ or €"); 
            } 
            if(price > money) {
                money = 0;
                System.out.println("You don't have enough funds to cover your fueling");
            } else {                
                this.printSeparator();
                System.out.println("Payment succesful. Your change is " + formatPrice(money - price));
                this.printSeparator();
                System.out.println("Fueling started.");
                status = true;
            }
        }                
        return status;
    } 
    public boolean checkPumpStayFilled(double givenPetrol) {       
        boolean status = false;
        
        if (this.availablePetrolLevel() - givenPetrol >= 0) {           
            status = true;
        }
        return status;
    }
    public void addFuel(double addPetrol) {
        this.currentPetrolLevel += addPetrol;        
        System.out.println("Filling amount of petrol " + addPetrol);
        //Show amount of petrol available after filling Pump               
        this.printSeparator();
        System.out.println("Amount of " + this.petrolType + " petrol in a pump after re-filling: " + this.availablePetrolLevel());
    }
    
    public String formatPrice(double price) {
        //Declare price formatter
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        
        //Operation price output
        //System.out.println(currencyFormatter.format(price));
        
        return currencyFormatter.format(price);
    }
    public void startFuelling() {
        //Show welcome message
        System.out.println("Welcome to Petrol Station 'Harakiri' at Groove Street, Los Angeles");
        //Show amount of petrol available before pump                
        this.printSeparator();
        System.out.println("Amount of " + this.petrolType + " petrol in a pump before fueling " + this.availablePetrolLevel());
        
        //Declare input variable
        double fuelBuyAmount = 0;
                
        //Input customer data
        while(fuelBuyAmount == 0) {      
            boolean checkAvailability = false;
            while(checkAvailability == false) {                     
                this.printSeparator();
                System.out.print("Amount of " + this.petrolType + " petrol you wish to purchase: ");    
                try {
                    fuelBuyAmount = Double.parseDouble(this.Input.next());
                } catch(NumberFormatException e) {
                    System.out.println("Put number in litres"); 
                } 
                if(this.checkPumpStayFilled(fuelBuyAmount) == false) {
                    System.out.println("You cannot get more petrol than the minimum petrol quantity.");  
                } else {
                    checkAvailability = true;
                }
            }
        }        
        //Trying to buy Fuel          
        this.fillCarFromPump(fuelBuyAmount);
    }
}
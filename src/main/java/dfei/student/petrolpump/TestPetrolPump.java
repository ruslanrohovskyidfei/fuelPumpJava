/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dfei.student.petrolpump;
import java.util.Scanner; //Import Scanner

/**
 *
 * @author 20231437
 */
public class TestPetrolPump {
    private PetrolPump Pump;
    
    TestPetrolPump(PetrolPump Pump) {
        this.Pump = Pump;        
    }
    public void startOperation() {        
        //Initializing Input/Output
        Scanner Input = new Scanner(System.in);
        
        //Declare input variable
        int fuelBuyAmount = 0;
        
        System.out.println("Amount of petrol in pump " + Pump.currentPetrolLevel());
        
        //Input customer data
        while(fuelBuyAmount == 0) {
            System.out.print("Amount of petrol you wish to purchase: ");    
            try {
                fuelBuyAmount = Integer.parseInt(Input.next());
            } catch(NumberFormatException e) {
                System.out.println("Put number in litres"); 
            } 
        }
        //Trying to buy Fuel
        Pump.fillCarFromPump(fuelBuyAmount);
        //Adding 1000l of Fuel
        Pump.addFuel(1000);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dfei.student.petrolpump;

/**
 *
 * @author 20231437
 */

public class TestPetrolPump {
    private PetrolPump Pump;
    
    TestPetrolPump(PetrolPump Pump) {
        this.Pump = Pump;        
    }
    public void startTesting() {       
        //Running test
        Pump.startFuelling();
        //Adding 1000L of Fuel
        Pump.addFuel(1000);
    }    
}

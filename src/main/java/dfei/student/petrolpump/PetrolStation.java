/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dfei.student.petrolpump;
/**
 *
 * @author 20231437
 */
public class PetrolStation {
    public static void main(String[] args) {       
        PetrolPump Pump = new PetrolPump(0.75, 20000, 2, "Unleaded"); 
        TestPetrolPump TestPump = new TestPetrolPump(Pump);
        TestPump.startOperation();
    }
}

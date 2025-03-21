package model;

import java.util.ArrayList;
import java.util.List;


public abstract class Computer {
    private String serialNumber;
    private String brand;
    private String model;
    private ArrayList<ComputerService> repairs;
    
   public Computer(String serialNumber, String brand, String model) {
       this.serialNumber = serialNumber;
       this.brand = brand;
       this.model = model;
       this.repairs = new ArrayList<>();
   }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public void addRepair(ComputerService service) {
        this.repairs.add(service);
    }
    
    public void deleteRepair(ComputerService service) {
        this.repairs.remove(service);
    }
    
    public void updateRepair(ComputerService oldRepair, ComputerService newRepair) {
        int oldRepairIndex = this.repairs.indexOf(oldRepair);
        this.repairs.set(oldRepairIndex, newRepair);
    }
    
    
    public ArrayList<ComputerService> getRepairs() {
        return this.repairs;
    }
    
    public ComputerService getRepair(int index) {
        return this.repairs.get(index);
    }
   
}

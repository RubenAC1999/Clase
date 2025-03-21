
package model;

public interface IComputerService {
    Computer getComputer();
    void setComputer(Computer computer);
    
    MaintenanceType getMaintenanceType();
    void setMaintenanceType(MaintenanceType type);
    
    String getDescription();
    void setDescription(String description);
    
    String getObservations();
    void setObservations(String observations);
    
    String getDate();
    void setDate(String date);
    
    String getContactPerson();
    void setContactPerson(String contactPerson);
    
    String getContactPhone();
    void setContactPhone(String contactPhone);
    
    float getTotalPrice();
    void setTotalPrice(float totalPrice);
    
    boolean isRepaired();
    void setRepaired(boolean repaired);
}
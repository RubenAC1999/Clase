package model;

public class ComputerService implements IComputerService {

    private Computer computer;
    private MaintenanceType maintenanceType;
    private String description;
    private String observations;
    private String date;
    private String contactPerson;
    private String contactPhone;
    private float totalPrice;
    private boolean repaired;

    public ComputerService(Computer computer, MaintenanceType maintenanceType, String description, String observations,
            String date, String contactPerson, String contactPhone, float totalPrice, boolean repaired) {
        this.computer = computer;
        this.maintenanceType = maintenanceType;
        this.description = description;
        this.observations = observations;
        this.date = date;
        this.contactPerson = contactPerson;
        this.contactPhone = contactPhone;
        this.totalPrice = totalPrice;
        this.repaired = repaired;
    }

    @Override
    public Computer getComputer() {
        return computer;
    }

    @Override
    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public MaintenanceType getMaintenanceType() {
        return this.maintenanceType;
    }

    @Override
    public void setMaintenanceType(MaintenanceType type) {
        this.maintenanceType = type;
    }

    @Override
    public String getDescription() {

        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getObservations() {
        return this.observations;
    }

    @Override
    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String getDate() {
        return this.date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getContactPerson() {
        return this.contactPerson;
    }

    @Override
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public String getContactPhone() {
        return this.contactPhone;
    }

    @Override
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public float getTotalPrice() {
        return this.totalPrice;
    }

    @Override
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean isRepaired() {
        return this.repaired;
    }

    @Override
    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

}

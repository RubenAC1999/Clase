package controller.serviceDetailsController;

import controller.computerManagementController.ComputerManagementController;
import controller.maintenanceListener.MaintenanceListener;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JComboBox;
import model.Ald;
import model.Computer;
import model.ComputerService;
import view.serviceDetails.ServiceDetailsDialog;
import model.MaintenanceType;

public class ServiceDetailsController {

    private ServiceDetailsDialog view;
    private Ald ald;
    private MaintenanceListener listener;
    private ComputerService service;
    private boolean isEditing;

    public ServiceDetailsController(ServiceDetailsDialog view, Ald ald,
            MaintenanceListener listener, ComputerService service, boolean isEditing) {
        this.view = view;
        this.ald = ald;
        this.listener = listener;
        this.service = service;
        this.isEditing = isEditing;
        initComponents();
        view.addSaveButtonActionListener(this.getSaveButtonActionListener());
    }

    private void initComponents() {
        setService(this.service);
        fillMaintenanceTypeComboBox();
    }

    private void fillMaintenanceTypeComboBox() {
        MaintenanceType[] values = MaintenanceType.values();

        JComboBox<String> comboBox = view.getMaintenanceTypeComboBox();
        comboBox.removeAllItems();
        for (MaintenanceType maintenance : values) {
            view.setMaintenanceTypeItemComboBox(maintenance);
        }
    }

    // TODO: añadir funcionalidad botón SAVE para editar un servicio
    private ActionListener getSaveButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                MaintenanceType maintenance = MaintenanceType.valueOf(view.getMaintenanceTypeComboBoxItem());
                String contactPerson = view.getContactPersonTextField();
                String phone = view.getPhoneTextField();
                String description = view.getDescriptionTextField();
                String observations = view.getObservationsTextField();
                Boolean isRepaired = view.isMaintenancePerformedChecked();

                String repairmentDate = view.getRepairmentDateTextField();
                float totalPrice = Float.parseFloat(view.getTotalPriceTextField());

                ComputerService newService = new ComputerService(service.getComputer(), maintenance, description, observations,
                        repairmentDate, contactPerson, phone, totalPrice, isRepaired);

                if (isEditing) {
                    listener.onMaintenanceUpdated(service.getComputer(), service, newService);
                } else {
                    listener.onMaintenanceAdded(service.getComputer(), newService);

                }

            }
        };

        return al;
    }

    private void setService(ComputerService service) {
        view.setMaintenanceTypeItemComboBox(service.getMaintenanceType().toString());
        view.setContactPersonTextField(service.getContactPerson());
        view.setPhoneTextField(service.getContactPhone());
        view.setDescriptionTextField(service.getDescription());
        view.setObservationsTextField(service.getObservations());

        if (service.isRepaired()) {
            view.setMaintenancePerfomedCheckBox(true);
        } else {
            view.setMaintenancePerfomedCheckBox(false);
        }

        view.setRepairmentDateTextField(service.getDate());
        view.setTotalPriceTextField(service.getTotalPrice());
    }

}

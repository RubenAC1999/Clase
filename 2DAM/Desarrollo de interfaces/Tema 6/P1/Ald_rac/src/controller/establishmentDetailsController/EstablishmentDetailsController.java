package controller.establishmentDetailsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Ald;
import view.establishmentDetails.EstablishmentDetailsDialog;

public class EstablishmentDetailsController {

    private final EstablishmentDetailsDialog view;
    private Ald ald;

    public EstablishmentDetailsController(EstablishmentDetailsDialog view, Ald ald) {
        this.view = view;
        this.ald = ald;
        this.initComponents();
        this.view.addCancelButtonActionListener(this.getCancelButtonActionListener());
        this.view.addEditButtonActionListener(this.getEditButtonActionListener());
        this.view.addSaveButtonActionListener(this.getSaveButtonActionListener());
    }

    private void initComponents() {
        view.setNameTextField(ald.getName());
        view.setAddressTextField(ald.getAddress());
        view.setPhoneTextField(ald.getPhoneNumber());
        view.setNumberOfEmployees(ald.getNumberOfEmployees());
        view.setNameTextFieldEditable(false);
        view.setAddressTextFieldEditable(false);
        view.setPhoneTextFieldEditable(false);
        view.setEmployeesSpinnerEnabled(false);
        view.setSaveButtonEnabled(false);
        view.setEditButtonEnabled(true);
        view.setCancelButtonEnabled(false);
    }
    
    private ActionListener getSaveButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ald.setName(view.getNameTextField());
                ald.setAddress(view.getAddressTextField());
                ald.setPhoneNumber(view.getPhoneTextField());
                ald.setNumberOfEmployees(view.getEmployeesSpinnerValue());
                
                initComponents();
            }
            
        };
        
        return al;
    }

    
    private ActionListener getEditButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setNameTextFieldEditable(true);
                view.setAddressTextFieldEditable(true);
                view.setPhoneTextFieldEditable(true);
                view.setEmployeesSpinnerEnabled(true);
                view.setSaveButtonEnabled(true);
                view.setEditButtonEnabled(false);
                view.setCancelButtonEnabled(true);
            }

        };

        return al;
    }

    private ActionListener getCancelButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initComponents();
            }

        };

        return al;
    }

}

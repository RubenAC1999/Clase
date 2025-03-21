
package view.serviceDetails;

import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import model.MaintenanceType;


public class ServiceDetailsDialog extends javax.swing.JDialog {

   
    public ServiceDetailsDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    @SuppressWarnings("unchecked")
    
    public void setMaintenanceTypeItemComboBox(Object item) {
        this.maintenanceTypeComboBox.addItem(item.toString());
    }
    
    public String getMaintenanceTypeComboBoxItem() {
        return this.maintenanceTypeComboBox.getSelectedItem().toString();
    }
    
    public JComboBox<String> getMaintenanceTypeComboBox() {
        return this.maintenanceTypeComboBox;
    }
    
    public void setContactPersonTextField(String contactPerson) {
        this.contactPersonTextField.setText(contactPerson);
    }
    
    public String getContactPersonTextField() {
        return this.contactPersonTextField.getText();
    }
    
    public String getPhoneTextField() {
        return this.phoneTextField.getText();
    }
    
    public void setPhoneTextField(String phone) {
        this.phoneTextField.setText(phone);
    }
   
   public String getDescriptionTextField() {
       return this.descriptionTextField.getText();
   }
   
   public void setDescriptionTextField(String description) {
       this.descriptionTextField.setText(description);
   }
   
   public String getObservationsTextField() {
       return this.observationsTextField.getText();
   }
   
   public void setObservationsTextField(String observations) {
       this.observationsTextField.setText(observations);
   }
   
   public Boolean isMaintenancePerformedChecked() {
       return this.maintenancePerformedCheckBox.isSelected();
   }
   
   public void setMaintenancePerfomedCheckBox(boolean status) {
       this.maintenancePerformedCheckBox.setSelected(status);
   }
   
   public String getRepairmentDateTextField() {
       return this.repairmentDateTextField.getText();
   }
   
   public void setRepairmentDateTextField(String repairmentDate) {
       this.repairmentDateTextField.setText(repairmentDate);
   }
   
   public String getTotalPriceTextField() {
       return this.totalPriceTextField.getText();
   }
   
   public void setTotalPriceTextField(float totalPrice) {
       this.totalPriceTextField.setText(String.valueOf(totalPrice));
   }
   
   public void addSaveButtonActionListener(ActionListener listener) {
       this.saveButton.addActionListener(listener);
   }
   
  
   
  
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        maintenanceTypeLabel = new javax.swing.JLabel();
        underlineLabel = new javax.swing.JLabel();
        serviceDetailsLabel = new javax.swing.JLabel();
        personLabel = new javax.swing.JLabel();
        contactPersonTextField = new javax.swing.JTextField();
        maintenanceTypeComboBox = new javax.swing.JComboBox<>();
        phoneLabel = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        observationsLabel = new javax.swing.JLabel();
        observationsTextField = new javax.swing.JTextField();
        maintenancePerformedCheckBox = new javax.swing.JCheckBox();
        repairmentDateLabel = new javax.swing.JLabel();
        repairmentDateTextField = new javax.swing.JTextField();
        totalPriceLabel = new javax.swing.JLabel();
        totalPriceTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        maintenanceTypeLabel.setText("Maintenance type:");

        underlineLabel.setText("_____________________________");

        serviceDetailsLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        serviceDetailsLabel.setText("Service Details");

        personLabel.setText("Contact person:");

        phoneLabel.setText("Phone:");

        descriptionLabel.setText("Description:");

        observationsLabel.setText("Observations:");

        maintenancePerformedCheckBox.setText("Maintenance performed");

        repairmentDateLabel.setText("Repairment Date:");

        totalPriceLabel.setText("Total price:");

        saveButton.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(phoneLabel)
                                    .addComponent(descriptionLabel)
                                    .addComponent(observationsLabel)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(repairmentDateLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(totalPriceLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(descriptionTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                .addComponent(phoneTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(observationsTextField)
                                .addComponent(repairmentDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(totalPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(personLabel)
                            .addComponent(maintenanceTypeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maintenanceTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(contactPersonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(maintenancePerformedCheckBox)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(serviceDetailsLabel)
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(underlineLabel)
                        .addGap(92, 92, 92))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(serviceDetailsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(underlineLabel)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maintenanceTypeLabel)
                    .addComponent(maintenanceTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personLabel)
                    .addComponent(contactPersonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(observationsLabel)
                    .addComponent(observationsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(maintenancePerformedCheckBox)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repairmentDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(repairmentDateLabel))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalPriceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
 
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contactPersonTextField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JCheckBox maintenancePerformedCheckBox;
    private javax.swing.JComboBox<String> maintenanceTypeComboBox;
    private javax.swing.JLabel maintenanceTypeLabel;
    private javax.swing.JLabel observationsLabel;
    private javax.swing.JTextField observationsTextField;
    private javax.swing.JLabel personLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel repairmentDateLabel;
    private javax.swing.JTextField repairmentDateTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel serviceDetailsLabel;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JTextField totalPriceTextField;
    private javax.swing.JLabel underlineLabel;
    // End of variables declaration//GEN-END:variables
}

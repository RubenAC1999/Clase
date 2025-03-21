package view.computerManagement;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class ComputerManagementDialog extends javax.swing.JDialog {

    public ComputerManagementDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        computerManagementLabel = new javax.swing.JLabel();
        computerManagementTabbedPane = new javax.swing.JTabbedPane();
        computersPanel = new javax.swing.JPanel();
        computersScrollPane = new javax.swing.JScrollPane();
        computersTable = new javax.swing.JTable();
        addComputerButton = new javax.swing.JButton();
        editComputerButton = new javax.swing.JButton();
        removeComputerButton = new javax.swing.JButton();
        serialNumberLabel = new javax.swing.JLabel();
        serialNumberTextField = new javax.swing.JTextField();
        brandLabel = new javax.swing.JLabel();
        modelLabel = new javax.swing.JLabel();
        brandTextField = new javax.swing.JTextField();
        modelTextField = new javax.swing.JTextField();
        computerTypeLabel = new javax.swing.JLabel();
        computerTypeComboBox = new javax.swing.JComboBox<>();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        attributeLabel = new javax.swing.JLabel();
        attributeTextField = new javax.swing.JTextField();
        messageLabel = new javax.swing.JLabel();
        servicesPanel = new javax.swing.JPanel();
        servicesScrollPane = new javax.swing.JScrollPane();
        servicesTable = new javax.swing.JTable();
        removeServiceButton = new javax.swing.JButton();
        editServiceButton = new javax.swing.JButton();
        addServiceButton = new javax.swing.JButton();
        descriptionLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        separatorLabel = new javax.swing.JLabel();
        repairmentDateLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        totalPrice = new javax.swing.JLabel();
        repairmentDate = new javax.swing.JLabel();
        observationsTextField = new javax.swing.JTextField();
        observationsLabel = new javax.swing.JLabel();
        serviceMessageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        computerManagementLabel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        computerManagementLabel.setText("Computer Management");

        computerManagementTabbedPane.setBackground(new java.awt.Color(245, 245, 255));

        computersPanel.setBackground(new java.awt.Color(245, 245, 255));

        computersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial Number", "Brand", "Model", "maintenanceTypeLabel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        }
    );
    computersTable.setGridColor(new java.awt.Color(255, 255, 255));
    computersTable.setSelectionBackground(new java.awt.Color(204, 204, 255));
    computersScrollPane.setViewportView(computersTable);

    addComputerButton.setText("Add");

    editComputerButton.setText("Edit");

    removeComputerButton.setBackground(new java.awt.Color(255, 204, 204));
    removeComputerButton.setText("Remove");

    serialNumberLabel.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
    serialNumberLabel.setText("Serial Number: ");

    brandLabel.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
    brandLabel.setText("Brand: ");

    modelLabel.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
    modelLabel.setText("Model: ");

    computerTypeLabel.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
    computerTypeLabel.setText("Type: ");

    computerTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                     ", "Desktop Computer", "Laptop", "All in One" }));

    saveButton.setText("Save");

    cancelButton.setBackground(new java.awt.Color(255, 204, 204));
    cancelButton.setText("Cancel");

    attributeLabel.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
    attributeLabel.setText("           Attribute: ");

    messageLabel.setForeground(new java.awt.Color(255, 102, 102));
    messageLabel.setText("                                            ");

    javax.swing.GroupLayout computersPanelLayout = new javax.swing.GroupLayout(computersPanel);
    computersPanel.setLayout(computersPanelLayout);
    computersPanelLayout.setHorizontalGroup(
        computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(computersPanelLayout.createSequentialGroup()
            .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(computersPanelLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(computersPanelLayout.createSequentialGroup()
                            .addComponent(serialNumberLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(serialNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(computersPanelLayout.createSequentialGroup()
                            .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(modelLabel)
                                .addComponent(brandLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(brandTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                .addComponent(modelTextField))))
                    .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(computersPanelLayout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(attributeLabel)
                                .addGroup(computersPanelLayout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addComponent(computerTypeLabel)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(computerTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(attributeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(computersPanelLayout.createSequentialGroup()
                            .addGap(103, 103, 103)
                            .addComponent(saveButton)
                            .addGap(59, 59, 59)
                            .addComponent(cancelButton))))
                .addGroup(computersPanelLayout.createSequentialGroup()
                    .addGap(181, 181, 181)
                    .addComponent(removeComputerButton)
                    .addGap(49, 49, 49)
                    .addComponent(editComputerButton)
                    .addGap(48, 48, 48)
                    .addComponent(addComputerButton)))
            .addContainerGap(97, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, computersPanelLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(messageLabel)
            .addGap(247, 247, 247))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, computersPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(computersScrollPane)
            .addContainerGap())
    );
    computersPanelLayout.setVerticalGroup(
        computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(computersPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(computersScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(addComputerButton)
                .addComponent(editComputerButton)
                .addComponent(removeComputerButton))
            .addGap(24, 24, 24)
            .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(serialNumberLabel)
                .addComponent(serialNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(computerTypeLabel)
                .addComponent(computerTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(brandLabel)
                .addComponent(brandTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(attributeLabel)
                .addComponent(attributeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelLabel)
                    .addComponent(modelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(computersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
            .addComponent(messageLabel)
            .addContainerGap())
    );

    computerManagementTabbedPane.addTab("Computers", computersPanel);

    servicesPanel.setBackground(new java.awt.Color(245, 245, 255));

    servicesTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Serial Number", "Type", "Person", "Phone", "Status"
        }
    ) {
        boolean[] canEdit = new boolean [] {
            false, false, false, false, false
        };

        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
        }
    });
    servicesScrollPane.setViewportView(servicesTable);

    removeServiceButton.setBackground(new java.awt.Color(255, 204, 204));
    removeServiceButton.setText("Remove");

    editServiceButton.setText("Edit...");

    addServiceButton.setText("Add...");

    descriptionLabel.setText("Description: ");

    separatorLabel.setText("____________________________________________________");

    repairmentDateLabel.setText("Repairment date: ");

    priceLabel.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
    priceLabel.setText("Total price: ");

    totalPrice.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
    totalPrice.setText("0.00");

    repairmentDate.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
    repairmentDate.setText("11/11/1111");

    observationsLabel.setText("Observations:");

    serviceMessageLabel.setForeground(new java.awt.Color(255, 102, 102));
    serviceMessageLabel.setToolTipText("");

    javax.swing.GroupLayout servicesPanelLayout = new javax.swing.GroupLayout(servicesPanel);
    servicesPanel.setLayout(servicesPanelLayout);
    servicesPanelLayout.setHorizontalGroup(
        servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(servicesPanelLayout.createSequentialGroup()
            .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(servicesPanelLayout.createSequentialGroup()
                    .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(servicesPanelLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(repairmentDateLabel)
                                .addComponent(priceLabel))
                            .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(servicesPanelLayout.createSequentialGroup()
                                    .addGap(189, 189, 189)
                                    .addComponent(repairmentDate))
                                .addGroup(servicesPanelLayout.createSequentialGroup()
                                    .addGap(210, 210, 210)
                                    .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(serviceMessageLabel)
                                        .addComponent(totalPrice)))))
                        .addGroup(servicesPanelLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(descriptionLabel)
                                .addComponent(observationsLabel))
                            .addGap(18, 18, 18)
                            .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(servicesPanelLayout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addComponent(removeServiceButton)
                                    .addGap(46, 46, 46)
                                    .addComponent(editServiceButton)
                                    .addGap(51, 51, 51)
                                    .addComponent(addServiceButton))
                                .addComponent(descriptionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                                .addComponent(observationsTextField))))
                    .addGap(0, 60, Short.MAX_VALUE))
                .addGroup(servicesPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(servicesScrollPane)))
            .addContainerGap())
        .addGroup(servicesPanelLayout.createSequentialGroup()
            .addGap(163, 163, 163)
            .addComponent(separatorLabel)
            .addContainerGap(163, Short.MAX_VALUE))
    );
    servicesPanelLayout.setVerticalGroup(
        servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(servicesPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(servicesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(addServiceButton)
                .addComponent(editServiceButton)
                .addComponent(removeServiceButton))
            .addGap(24, 24, 24)
            .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(descriptionLabel)
                .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(14, 14, 14)
            .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(observationsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(observationsLabel))
            .addGap(18, 18, 18)
            .addComponent(separatorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(repairmentDateLabel)
                .addComponent(repairmentDate))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(servicesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(priceLabel)
                .addComponent(totalPrice))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
            .addComponent(serviceMessageLabel)
            .addContainerGap())
    );

    computerManagementTabbedPane.addTab("Services", servicesPanel);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(225, 225, 225)
            .addComponent(computerManagementLabel)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addComponent(computerManagementTabbedPane)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(computerManagementLabel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(computerManagementTabbedPane)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addRowComputerTable(Vector row) {
        DefaultTableModel model = (DefaultTableModel) this.computersTable.getModel();
        model.addRow(row);
    }

    public void addRowServiceTable(Vector row) {
        DefaultTableModel model = (DefaultTableModel) this.servicesTable.getModel();
        model.addRow(row);
    }

    public void clearComputers() {
        DefaultTableModel model = (DefaultTableModel) this.computersTable.getModel();
        model.setRowCount(0);
        computersTable.clearSelection();
        computersTable.revalidate();
        computersTable.repaint();
    }

    public void clearServices() {
        DefaultTableModel model = (DefaultTableModel) this.servicesTable.getModel();
        model.setRowCount(0);
        servicesTable.clearSelection();
        servicesTable.revalidate();
        servicesTable.repaint();
    }

    public void clearTextFields() {
        this.serialNumberTextField.setText("");
        this.brandTextField.setText("");
        this.modelTextField.setText("");
        this.attributeTextField.setText("");
        this.computerTypeComboBox.setSelectedIndex(0);
    }
    private int lastSelectedRow = -1;

    public void setLastSelectedRow(int selection) {
        this.lastSelectedRow = selection;
    }

    public int getLastSelectedRow() {
        return this.lastSelectedRow;
    }

    public void addComputersScrollPaneMouseListener(MouseListener listener) {
        this.computersScrollPane.addMouseListener(listener);
    }

    private int computerSelectedRow;
    private int serviceSelectedRow;

    public void clearSelection() {
        this.computersTable.clearSelection();
    }

    public String getComputerInfo(int row, int column) {
        String info = "";
        if (row >= 0 && column >= 0) {
            info = computersTable.getModel().getValueAt(row, column).toString();
        }

        return info;
    }
    
    public String getServiceInfo(int row, int column) {
        String info = "";
        if (row >= 0 && column >= 0) {
            info = servicesTable.getModel().getValueAt(row, column).toString();
        }
        
        return info;
    }

    public boolean isRowSelected(boolean b) {
        if (computersTable.getSelectedRow() == -1) {
            return false;
        }

        return true;
    }

    public void setComputerSelectedRow(int row) {
        this.computerSelectedRow = row;
    }

    public void addComputerActionListener(ActionListener listener) {
        this.addComputerButton.addActionListener(listener);
    }

    public void addEditComputerActionListener(ActionListener listener) {
        this.editComputerButton.addActionListener(listener);
    }

    public void addRemoveComputerActionListener(ActionListener listener) {
        this.removeComputerButton.addActionListener(listener);
    }

    public void setAttributeLabelName(String name) {
        this.attributeLabel.setText(name);
    }

    public void setAttributeLabelVisibility(boolean status) {
        this.attributeLabel.setVisible(status);
    }

    public void setAttributeTextFieldVisibility(boolean status) {
        this.attributeTextField.setVisible(status);
    }

    public void addComputerTypeOptionActionListener(ActionListener listener) {
        this.computerTypeComboBox.addActionListener(listener);
    }

    public String getComputerTypeOption() {
        return this.computerTypeComboBox.getSelectedItem().toString();
    }

    public String getSerialNumberTextField() {
        return this.serialNumberTextField.getText();
    }

    public String getBrandTextField() {
        return this.brandTextField.getText();
    }

    public String getModelTextField() {
        return this.modelTextField.getText();
    }

    public String getComputerTypeComboBox() {
        return this.computerTypeComboBox.getSelectedItem().toString();
    }

    public String getAttributeTextField() {
        return this.attributeTextField.getText();
    }

    public int getComputerSelectedRow() {
        return this.computerSelectedRow = computersTable.getSelectedRow();
    }
    
    public int getServiceSelectedRow() {
        return this.serviceSelectedRow = servicesTable.getSelectedRow();
    }

    public int getSelectedColumn() {
        return this.computersTable.getSelectedColumn();
    }

    public void setSerialNumberTextField(String text) {
        this.serialNumberTextField.setText(text);
    }

    public void setBrandTextField(String text) {
        this.brandTextField.setText(text);
    }

    public void setModelTextField(String text) {
        this.modelTextField.setText(text);
    }

    public void setComputerTypeOption(int option) {
        this.computerTypeComboBox.setSelectedIndex(option);
    }

    public void setAttributeTextField(String text) {
        this.attributeTextField.setText(text);
    }

    public void setComputersScrollPaneEnable(boolean status) {
        this.computersScrollPane.setEnabled(status);
    }

    public boolean isComputerScrollPaneEnable() {
        return this.computersScrollPane.isEnabled();
    }

    public void setComputersTableEnable(boolean status) {
        this.computersTable.setEnabled(status);
    }

    public void setRemoveButtonEnable(boolean status) {
        this.removeComputerButton.setEnabled(status);
    }

    public void setEditButtonEnable(boolean status) {
        this.editComputerButton.setEnabled(status);
    }

    public void setAddButtonEnable(boolean status) {
        this.addComputerButton.setEnabled(status);
    }

    public void setSerialNumberTextFieldEnable(boolean status) {
        this.serialNumberTextField.setEnabled(status);
    }

    public void setBrandTextFieldEnable(boolean status) {
        this.brandTextField.setEnabled(status);
    }

    public void setModelTextFieldEnable(boolean status) {
        this.modelTextField.setEnabled(status);
    }

    public void setComputerTypeComboBoxEnable(boolean status) {
        this.computerTypeComboBox.setEnabled(status);
    }

    public void setAttributeTextFieldEnable(boolean status) {
        this.attributeTextField.setEnabled(status);
    }

    public void setSaveButtonEnable(boolean status) {
        this.saveButton.setEnabled(status);
    }

    public void setCancelButtonEnable(boolean status) {
        this.cancelButton.setEnabled(status);
    }
    
    public void setDescriptionTextField(String text) {
        this.descriptionTextField.setText(text);
    }
    
    public void setObservationsTextField(String text) {
        this.observationsTextField.setText(text);
    }
    
    public void setDescriptionTextFieldEnable(boolean status) {
        this.descriptionTextField.setEnabled(status);
    }
    
    public void setObservationsTextFieldEnable(boolean status) {
        this.observationsTextField.setEnabled(status);
    }
    
    public void setSeparatorLabelVisibility(boolean status) {
        this.separatorLabel.setVisible(status);
    }
    
    public void setPriceLabelVisibility(boolean status) {
        this.priceLabel.setVisible(status);
    }
    
    public void setTotalPriceText(String text) {
        this.totalPrice.setText(text);
    }
    
    public void setTotalPriceVisibility(boolean status) {
        this.totalPrice.setVisible(status);
    }
    
    public void setRepairmentDateText(String text) {
        this.repairmentDate.setText(text);
    }
    
    public void setRepairmentDateVisibility(boolean status) {
        this.repairmentDate.setVisible(status);
    }

    public void setRepairmentDateLabelVisibility(boolean status) {
        this.repairmentDateLabel.setVisible(status);
    }
    public void addSaveButtonActionListener(ActionListener listener) {
        this.saveButton.addActionListener(listener);
    }

    public void addCancelButtonActionListener(ActionListener listener) {
        this.cancelButton.addActionListener(listener);
    }

    public void addComputersTableMouseListener(MouseListener listener) {
        this.computersTable.addMouseListener(listener);
    }

    public void addServicesTableMouseListener(MouseListener listener) {
        this.servicesTable.addMouseListener(listener);
    }
    
    public void setMessageLabelText(String text) {
        this.messageLabel.setText(text);
    }

    public void addServiceButtonActionListener(ActionListener listener) {
        this.addServiceButton.addActionListener(listener);
    }
   
    public void setAddServiceButtonEnable(boolean status) {
        this.addServiceButton.setEnabled(status);
    }
    
    public void addEditServiceButtonActionListener(ActionListener listener) {
        this.editServiceButton.addActionListener(listener);
    }
    
    public void setEditServiceButtonEnable(boolean status) {
        this.editServiceButton.setEnabled(status);
    }
    
    public void addRemoveServiceButtonActionListener(ActionListener listener) {
        this.removeServiceButton.addActionListener(listener);
    }
    
    public void setRemoveServiceButtonEnable(boolean status) {
        this.removeServiceButton.setEnabled(status);
    }
    
    public void setServiceMessageLabelText(String text) {
        this.serviceMessageLabel.setText(text);
    }
    
    public String getServiceMessageLabelText() {
        return this.serviceMessageLabel.getText();
    }
    
    public boolean isAnyTextFieldBlank() {
        String[] textFields = {getSerialNumberTextField(), getBrandTextField(),
            getModelTextField(), getAttributeTextField()
        };

        for (String tf : textFields) {
            if (tf.isBlank()) {
                return true;
            }
        }

        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addComputerButton;
    private javax.swing.JButton addServiceButton;
    private javax.swing.JLabel attributeLabel;
    private javax.swing.JTextField attributeTextField;
    private javax.swing.JLabel brandLabel;
    private javax.swing.JTextField brandTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel computerManagementLabel;
    private javax.swing.JTabbedPane computerManagementTabbedPane;
    private javax.swing.JComboBox<String> computerTypeComboBox;
    private javax.swing.JLabel computerTypeLabel;
    private javax.swing.JPanel computersPanel;
    private javax.swing.JScrollPane computersScrollPane;
    private javax.swing.JTable computersTable;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JButton editComputerButton;
    private javax.swing.JButton editServiceButton;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JTextField modelTextField;
    private javax.swing.JLabel observationsLabel;
    private javax.swing.JTextField observationsTextField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JButton removeComputerButton;
    private javax.swing.JButton removeServiceButton;
    private javax.swing.JLabel repairmentDate;
    private javax.swing.JLabel repairmentDateLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel separatorLabel;
    private javax.swing.JLabel serialNumberLabel;
    private javax.swing.JTextField serialNumberTextField;
    private javax.swing.JLabel serviceMessageLabel;
    private javax.swing.JPanel servicesPanel;
    private javax.swing.JScrollPane servicesScrollPane;
    private javax.swing.JTable servicesTable;
    private javax.swing.JLabel totalPrice;
    // End of variables declaration//GEN-END:variables
}

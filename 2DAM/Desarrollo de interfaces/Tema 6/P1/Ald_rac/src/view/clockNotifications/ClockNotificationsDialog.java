
package view.clockNotifications;

import java.awt.event.ActionListener;

public class ClockNotificationsDialog extends javax.swing.JDialog {

    public ClockNotificationsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void addSetClockButtonActionListener(ActionListener listener) {
        this.setClockButton.addActionListener(listener);
    }
    
    public void setSetClockButtonEnabled(boolean status) {
        this.setClockButton.setEnabled(status);
    }
    
    public void setDisableAlarmButtonEnabled(boolean status) {
        this.alarmButton.setEnabled(status);
    }
    
    
    public void addDisableAlarmButtonActionListener(ActionListener listener) {
        this.alarmButton.addActionListener(listener);
    }
    
    public int getHourSpinnerValue() {
        return (Integer) this.hoursSpinner.getValue();
    }
    
    public void setHourSpinnerValue(int value) {
        this.hoursSpinner.setValue(value);
    }
    
    public void setHourSpinnerEnabled(boolean status) {
        this.hoursSpinner.setEnabled(status);
    }
    
    public void setMinutesSpinnerValue(int value) {
        this.minutesSpinner.setValue(value);
    }
    
    public void setMinutesSpinnerEnabled(boolean status) {
        this.minutesSpinner.setEnabled(status);
    }
    
    public int getMinutesSpinnerValue() {
        return (Integer) this.minutesSpinner.getValue();
    }
    
    public boolean isMode12hRadioButtonSelected() {
        return this.mode12hRadioButton.isSelected();
    }
    
    public boolean isMode24hRadioButtonSelected() {
        return this.mode24hRadioButton.isSelected();
    }
    
    public void setClockModeButtonGroupEnabled(boolean status) {
        this.mode12hRadioButton.setEnabled(status);
        this.mode24hRadioButton.setEnabled(status);
    }
     
    public String getMessageTextField() {
        return this.messageTextField.getText();
    }
    
    public void setMessageTextField(String message) {
        this.messageTextField.setText(message);
    }
    
    public void setMessageTextFieldEnabled(boolean status) {
        this.messageTextField.setEnabled(status);
    }
    
    public void setMode24HSelected(boolean b) {
        this.mode24hRadioButton.setSelected(b);
    }
    
    public void setMode12HSelected(boolean b) {
        this.mode12hRadioButton.setSelected(b);
    }
    
    public void setAlarmButtonText(String text) {
        this.alarmButton.setText(text);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clockModeButtonGroup = new javax.swing.ButtonGroup();
        clockModeLabel = new javax.swing.JLabel();
        mode24hRadioButton = new javax.swing.JRadioButton();
        mode12hRadioButton = new javax.swing.JRadioButton();
        alertTimeLabel = new javax.swing.JLabel();
        hoursSpinner = new javax.swing.JSpinner();
        minutesSpinner = new javax.swing.JSpinner();
        messageLabel = new javax.swing.JLabel();
        messageTextField = new javax.swing.JTextField();
        setClockButton = new javax.swing.JButton();
        alarmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(245, 245, 255));

        clockModeLabel.setText("Clock mode: ");

        clockModeButtonGroup.add(mode24hRadioButton);
        mode24hRadioButton.setText("24H");

        clockModeButtonGroup.add(mode12hRadioButton);
        mode12hRadioButton.setText("12H");

        alertTimeLabel.setText("Alert time: ");

        hoursSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        minutesSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        messageLabel.setText("Message: ");

        setClockButton.setText("Set clock");

        alarmButton.setText("Disable alarm");
        alarmButton.setPreferredSize(new java.awt.Dimension(78, 29));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setClockButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clockModeLabel)
                            .addComponent(alertTimeLabel)
                            .addComponent(messageLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(mode24hRadioButton))
                                    .addComponent(hoursSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mode12hRadioButton)
                                    .addComponent(minutesSpinner)))
                            .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(alarmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mode24hRadioButton)
                    .addComponent(mode12hRadioButton)
                    .addComponent(clockModeLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hoursSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(minutesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(alertTimeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageLabel)
                    .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(setClockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alarmButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alarmButton;
    private javax.swing.JLabel alertTimeLabel;
    private javax.swing.ButtonGroup clockModeButtonGroup;
    private javax.swing.JLabel clockModeLabel;
    private javax.swing.JSpinner hoursSpinner;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextField messageTextField;
    private javax.swing.JSpinner minutesSpinner;
    private javax.swing.JRadioButton mode12hRadioButton;
    private javax.swing.JRadioButton mode24hRadioButton;
    private javax.swing.JButton setClockButton;
    // End of variables declaration//GEN-END:variables
}


package controller.clockNotifications;

import clock.AlarmEvent;
import clock.ClockBean;
import clock.IAlarmListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.MainJFrame;
import view.clockNotifications.ClockNotificationsDialog;


public class ClockNotificationsController {
    private ClockNotificationsDialog view;
    private MainJFrame parentFrame;

    public ClockNotificationsController(ClockNotificationsDialog view, MainJFrame parentFrame) {
        this.view = view;
        this.parentFrame = parentFrame;
        this.view.addSetClockButtonActionListener(this.getSetClockButtonActionListener());
        this.view.addDisableAlarmButtonActionListener(this.getAlarmButtonActionListener());
        initComponents();
    }
    
    public void initComponents() {
        if (parentFrame.isClockBeanMode24()) {
            view.setMode24HSelected(true);
        } else {
            view.setMode12HSelected(true);
        }
        if(parentFrame.isAlarmEnabled()) {
            view.setHourSpinnerValue(parentFrame.getHourAlarm());
            view.setMinutesSpinnerValue(parentFrame.getMinutesAlarm());
            view.setMessageTextField(parentFrame.getAlarmMessage());
            view.setAlarmButtonText("Disable Alarm"); 
        } else {
            view.setAlarmButtonText("Enable Alarm");
        }
       
    }
   
    public ActionListener getSetClockButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.isMode24hRadioButtonSelected()) {
                    parentFrame.setClockBeanMode24h(true);
                } else {
                    parentFrame.setClockBeanMode24h(false);
                }                
                initComponents();
            }
            
        };
        return al;  
    }
    
    public ActionListener getAlarmButtonActionListener() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (parentFrame.isAlarmEnabled()) {
                    parentFrame.setClockBeanAlarmEnabled(false);
                    
                } else {
                    parentFrame.setClockBeanAlarmEnabled(true);
                    
                    int hour = view.getHourSpinnerValue();
                    int minutes = view.getMinutesSpinnerValue();
                    String message = view.getMessageTextField();
                
                    parentFrame.setAlarm(hour, minutes);
                    parentFrame.setAlarmMessage(message);
                    parentFrame.setClockBeanAlarmListener(parentFrame);
                }
                initComponents();
            }
            
        };
        
        return listener;
    }

    
    
    
    
}

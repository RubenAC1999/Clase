
package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * ClockBean is a JavaBean component that displays the current time as a JLabel
 * and includes features such as 24-hour/12-hour format switching and alarm
 * functionality. 
 * It updates every second using a Timer.
 */
public class ClockBean extends JLabel implements ActionListener, Serializable {

    /**
     * Indicates if the clock is in 24-hour mode (true) or 12-hour mode (false).
     */
    public boolean mode24;

    /**
     * Indicates if the alarm functionality is enabled.
     */
    public boolean enableAlarm;

    /**
     * The minute at which the alarm is set.
     */
    public int minutesAlarm;

    /**
     * The hour at which the alarm is set.
     */
    public int hourAlarm;

    /**
     * Timer object that updates the clock display every second.
     */
    private final Timer t;

    /**
     * Calendar object used to retrieve the current time.
     */
    private Calendar calendar;

    /**
     * Listener interface for handling alarm events.
     */
    private IAlarmListener receptor;

    /**
     * A custom message that can be displayed or used when the alarm is activated.
     */
    private String message;

    /**
     * Array containing string representations of hours (00 to 23).
     */
    private final String[] hours = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    /**
     * Array containing string representations of minutes (00 to 59).
     */
    private final String[] minutes = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};

    /**
     * Array containing string representations of seconds (00 to 59).
     */
    private final String[] seconds = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};

    /**
     * Array containing string representations of AM/PM.
     */
    private final String[] AMPM = {"AM", "PM"};

    /**
     * Retrieves the custom message associated with the clock.
     * 
     * @return the custom message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets a custom message for the clock.
     * 
     * @param message the custom message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Checks whether the alarm functionality is enabled.
     * 
     * @return true if the alarm is enabled; false otherwise.
     */
    public boolean isEnableAlarm() {
        return enableAlarm;
    }

    /**
     * Enables or disables the alarm functionality.
     * 
     * @param enableAlarm true to enable the alarm; false to disable.
     */
    public void setEnableAlarm(boolean enableAlarm) {
        this.enableAlarm = enableAlarm;
    }

    /**
     * Retrieves the minute at which the alarm is set.
     * 
     * @return the alarm minute.
     */
    public int getMinutesAlarm() {
        return minutesAlarm;
    }

    /**
     * Sets the minute for the alarm to trigger.
     * 
     * @param minutesAlarm the alarm minute to set.
     */
    public void setMinutesAlarm(int minutesAlarm) {
        this.minutesAlarm = minutesAlarm;
    }

    /**
     * Retrieves the hour at which the alarm is set.
     * 
     * @return the alarm hour.
     */
    public int getHourAlarm() {
        return hourAlarm;
    }

    /**
     * Sets the hour for the alarm to trigger.
     * 
     * @param hourAlarm the alarm hour to set.
     */
    public void setHourAlarm(int hourAlarm) {
        this.hourAlarm = hourAlarm;
    }

    /**
     * Checks if the clock is in 24-hour mode.
     * 
     * @return true if the clock is in 24-hour mode; false if in 12-hour mode.
     */
    public boolean isMode24() {
        return mode24;
    }

    /**
     * Sets the clock's mode to 24-hour or 12-hour.
     * 
     * @param mode24 true for 24-hour mode; false for 12-hour mode.
     */
    public void setMode24(boolean mode24) {
        this.mode24 = mode24;
    }

    /**
     * Constructor that initializes the ClockBean with default settings and
     * starts the timer for updating the clock display.
     */
    public ClockBean() {
        this.setHorizontalAlignment(SwingConstants.RIGHT);
        message = "";
        mode24 = true;
        enableAlarm = false;
        t = new Timer(1000, this);
        t.start();
        calendar = Calendar.getInstance();

        String h = hours[calendar.get(Calendar.HOUR_OF_DAY)];
        String m = minutes[calendar.get(Calendar.MINUTE)];
        String s = seconds[calendar.get(Calendar.SECOND)];
        String AM_PM = AMPM[calendar.get(Calendar.AM_PM)];
        setText(h + ":" + m + ":" + s + " " + AM_PM);
    }

    /**
     * Updates the clock display every second and checks for alarm conditions.
     * If the alarm is enabled and matches the current time, the registered
     * alarm listener is triggered.
     * 
     * @param e the action event generated by the timer.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String h;
        String m;
        String s;
        String AM_PM;
        calendar = Calendar.getInstance();

        if (isMode24()) {
            h = hours[calendar.get(Calendar.HOUR_OF_DAY)];
            m = minutes[calendar.get(Calendar.MINUTE)];
            s = seconds[calendar.get(Calendar.SECOND)];
            setText(h + ":" + m + ":" + s);
        } else {
            h = hours[calendar.get(Calendar.HOUR)];
            m = minutes[calendar.get(Calendar.MINUTE)];
            s = seconds[calendar.get(Calendar.SECOND)];
            AM_PM = AMPM[calendar.get(Calendar.AM_PM)];
            setText(h + ":" + m + ":" + s + " " + AM_PM);
        }
        repaint();

        if (enableAlarm) {
            if ((Integer.parseInt(h) == hourAlarm) && (Integer.parseInt(m) == minutesAlarm)) {
                receptor.captureAlarm(new AlarmEvent(this));
            }
        }
    }

    /**
     * Adds an alarm listener to handle alarm events.
     * 
     * @param receptor the alarm listener to add.
     */
    public void addAlarmListener(IAlarmListener receptor) {
        this.receptor = receptor;
    }

    /**
     * Removes the alarm listener.
     * 
     * @param receptor the alarm listener to remove.
     */
    public void removeAlarmListener(IAlarmListener receptor) {
        this.receptor = null;
    }
}

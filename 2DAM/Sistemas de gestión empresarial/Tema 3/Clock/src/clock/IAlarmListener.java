/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clock;

import java.util.EventListener;

/**
 * An interface to capture the AlarmEvent
 * @author rac
 */
public interface IAlarmListener extends EventListener {

    /**
     * The method is called when an alarm event occurs.
     * @param ev The alarm event containing details about the triggered alarm.
     */
    public void captureAlarm(AlarmEvent ev);
}

package clock;

import java.util.EventObject;

/**
 * AlarmEvent is an extra class to handle the event displayed by the alarm.
 *
 * @author rac
 */
public class AlarmEvent extends EventObject {

    /**
     * Constructs a new AlarmEvent object.
     *
     * @param source the object on which the Event initially occurred (typically the ClockBean).
     * @throws IllegalArgumentException if source is null.
     */
    public AlarmEvent(Object source) {
        super(source);
    }

}
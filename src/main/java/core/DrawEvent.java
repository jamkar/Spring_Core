package core;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Karen on 26-Jun-17.
 */
public class DrawEvent extends ApplicationEvent {

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DrawEvent(Object source) {
        super(source);
    }

    @Override
    public String toString() {
        return "Draw Event Occurred";
    }
}

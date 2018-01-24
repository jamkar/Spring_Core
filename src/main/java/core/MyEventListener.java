package core;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Karen on 26-Jun-17.
 */
@Component
public class MyEventListener implements ApplicationListener {

    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println(event.toString());
    }
}
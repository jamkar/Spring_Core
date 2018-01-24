package core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by Karen on 23-Jun-17.
 */
@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

    private Point center;

    @Autowired
    private MessageSource messageSource;

    private ApplicationEventPublisher publisher;

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void draw() {
        System.err.println(messageSource.getMessage("greeting", null, "Default Greeting", null));
        System.err.println(messageSource.getMessage("drawing.circle", new Object[]{center.getX(), center.getY()}, "Default", null));

        //Event publishing
        DrawEvent drawEvent = new DrawEvent(this);
        publisher.publishEvent(drawEvent);
    }

    public Point getCenter() {
        return center;
    }

//    @Required
//    @Autowired
//    @Qualifier("circleRelated")
    @Resource(name = "pointB")
    public void setCenter(Point center) {
        this.center = center;
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Circle.@PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Circle.@PreDestroy");
    }
}

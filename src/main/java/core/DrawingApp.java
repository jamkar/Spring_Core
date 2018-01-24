package core;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * Created by Karen on 22-Jun-17.
 */
public class DrawingApp {

    public static void main(String[] args) {
//        BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
//        core.Triangle triangle = (core.Triangle) beanFactory.getBean("triangle");

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        context.registerShutdownHook();


        core.Triangle triangle = (core.Triangle) context.getBean("triangle");
//        triangle.draw();
        System.out.println(triangle);
        System.out.println(triangle.getPointA());
        System.out.println(triangle.getPointA());

        core.Triangle triangle1 = (core.Triangle) context.getBean("triangle");
//        triangle.draw();
        System.out.println(triangle1);
        System.out.println(triangle1.getPointA());
        System.out.println(triangle1.getPointA());

//        Shape shape = (Shape) context.getBean("circle");
//        shape.draw();

//        System.err.println(context.getMessage("greeting", null, "Default Greeting", null));
    }
}

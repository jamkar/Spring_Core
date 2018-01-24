package core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

/**
 * Created by Karen on 22-Jun-17.
 */
public abstract class Triangle implements Shape/*, ApplicationContextAware, BeanNameAware,
        InitializingBean, DisposableBean*/ {

    private String type;
    private int height;
    private Point pointA, pointB, pointC;
    private List<Point> points;
    private ApplicationContext context = null;

    public Triangle(String type, int height) {
        this.type = type;
        this.height = height;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void setBeanName(String name) {
        System.out.println("Bean name is: " + name);
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet()");
    }

    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy()");
    }

    public void myInit() {
        System.out.println("myInit method");
    }

    public void myCleanup() {
        System.out.println("myCleanup method");
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Point getPointA() {
        return point(); // Lookup method injection
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public String getType() {
        return type;
    }

//    public void setType(String type) {
//        this.type = type;
//    }


    public int getHeight() {
        return height;
    }

    public void draw() {
        System.out.println("Drawing triangle: Points: " + pointA.getX() + ", " + pointA.getY());
    }

    public void showPoints() {
        System.out.println("Points");
        for(Point point : getPoints()) {
            System.out.print(point + " ");
        }
    }

    public abstract Point point();  //Lookup method injection
}

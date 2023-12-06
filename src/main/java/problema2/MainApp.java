package problema2;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
       // AbstractApplicationContext context=new ClassPathXmlApplicationContext("beans_lab1.xml");
      //  Vehicul v = (Vehicul) context.getBean("autoturism");
       // Vehicul v2 = (Vehicul) context.getBean("autoturismConstructor");
        //System.out.println(v+"\n" + v2);

        //Vehicul v3 = (Vehicul) context.getBean("vehiculMostenire");
       // Vehicul v4 = (Vehicul) context.getBean("motocicleta");
        //System.out.println(v3 + "\n " + v4);
       // context.close();

        AbstractApplicationContext context2 = new ClassPathXmlApplicationContext("beans_lab2.xml");
        Vehicul v = (Vehicul) context2.getBean("tir");
        System.out.println(v);
        context2.registerShutdownHook();
        context2.close();
    }
}

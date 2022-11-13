package molicode.springframework.sfgdi;

import molicode.springframework.sfgdi.controller.ConstructorInjectedController;
import molicode.springframework.sfgdi.controller.I18nController;
import molicode.springframework.sfgdi.controller.MyController;
import molicode.springframework.sfgdi.controller.PetController;
import molicode.springframework.sfgdi.controller.PropertyInjectedController;
import molicode.springframework.sfgdi.controller.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

    PetController petController = ctx.getBean("petController", PetController.class);
    System.out.println("--- The Best Pet is ---");
    System.out.println(petController.whichPetIsTheBest());

    MyController myController = (MyController) ctx.getBean("myController");

    I18nController i18nController = (I18nController) ctx.getBean("i18nController");
    System.out.println(i18nController.sayHello());

    //		String greeting = myController.sayHello();

    System.out.println("------ Primary Bean");
    System.out.println(myController.sayHello());

    System.out.println("------ Property");
    PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
    System.out.println(propertyInjectedController.getGreeting());

    System.out.println("--------- Setter");
    SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
    System.out.println(setterInjectedController.getGreeting());

    System.out.println("-------- Constructor");
    ConstructorInjectedController constructorInjectedController =
        (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
    System.out.println(constructorInjectedController.getGreeting());
  }

}

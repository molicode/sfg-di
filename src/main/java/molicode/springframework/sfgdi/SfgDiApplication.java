package molicode.springframework.sfgdi;

import molicode.springframework.sfgdi.config.SfgConfiguration;
import molicode.springframework.sfgdi.config.SfgConstructorConfig;
import molicode.springframework.sfgdi.controller.ConstructorInjectedController;
import molicode.springframework.sfgdi.controller.I18nController;
import molicode.springframework.sfgdi.controller.MyController;
import molicode.springframework.sfgdi.controller.PetController;
import molicode.springframework.sfgdi.controller.PropertyInjectedController;
import molicode.springframework.sfgdi.controller.SetterInjectedController;
import molicode.springframework.sfgdi.datasource.FakeDataSource;
import molicode.springframework.sfgdi.services.PrototypeBean;
import molicode.springframework.sfgdi.services.SingletonBean;
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

    System.out.println("--- Bean Scopes ----------");
    SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
    System.out.println(singletonBean1.getMyScope());
    SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
    System.out.println(singletonBean2.getMyScope());

    PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
    System.out.println(prototypeBean1.getMyScope());
    PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
    System.out.println(prototypeBean2.getMyScope());

    System.out.println("--- Fake Data Source ----------");
    FakeDataSource fakeDataSource =  ctx.getBean(FakeDataSource.class);
    System.out.println(fakeDataSource.getUsername());
    System.out.println(fakeDataSource.getPassword());
    System.out.println(fakeDataSource.getJdbcurl());

    System.out.println("--- Config Props Bean ----------");
    SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
    System.out.println(sfgConfiguration.getUsername());
    System.out.println(sfgConfiguration.getPassword());
    System.out.println(sfgConfiguration.getJdbcurl());

    System.out.println("--- Constructor Binding ----------");
    SfgConstructorConfig sfgConstructorConfig = ctx.getBean(SfgConstructorConfig.class);
    System.out.println(sfgConstructorConfig.getUsername());
    System.out.println(sfgConstructorConfig.getPassword());
    System.out.println(sfgConstructorConfig.getJdbcurl());


  }

}

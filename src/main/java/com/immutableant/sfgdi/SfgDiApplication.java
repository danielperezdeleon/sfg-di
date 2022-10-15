package com.immutableant.sfgdi;

import com.immutableant.sfgdi.controllers.*;
import com.immutableant.sfgdi.repositories.datasource.FakeDataSource;
import com.immutableant.sfgdi.services.PrototypeBean;
import com.immutableant.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

    // Arrays.stream(ctx.getBeanDefinitionNames()).forEach(bean -> System.out.println(bean));

    System.out.println("------ Pet configs");

    PetController petController = ctx.getBean("petController", PetController.class);
    System.out.println("--- The Best Pet is ---");
    System.out.println(petController.whichPetIsTheBest());

    System.out.println("------ Profile Bean");

    I18nController i18nController = (I18nController) ctx.getBean("i18nController");

    System.out.println(i18nController.sayHello());

    System.out.println("------ PRIMARY Bean");
    MyController myController = (MyController) ctx.getBean("myController");

    System.out.println(myController.sayHello());

    System.out.println("------ Property based");

    PropertyInjectedController propertyInjectedController =
        (PropertyInjectedController) ctx.getBean("propertyInjectedController");

    System.out.println(propertyInjectedController.getGreeting());

    System.out.println("------ Setter based");

    SetterInjectedController setterInjectedController =
        (SetterInjectedController) ctx.getBean("setterInjectedController");

    System.out.println(setterInjectedController.getGreeting());

    System.out.println("------ Constructor based");

    ConstructorInjectedController constructorInjectedController =
        (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

    System.out.println(constructorInjectedController.getGreeting());

    System.out.println("---- Bean Scopes ---------");
    SingletonBean singletonBean1 = ctx.getBean(SingletonBean.class);
    System.out.println(singletonBean1.getMyScope());
    SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
    System.out.println(singletonBean2.getMyScope());

    PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
    System.out.println(prototypeBean1.getMyScope());
    PrototypeBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
    System.out.println(prototypeBean2.getMyScope());

    FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
    System.out.println(fakeDataSource.getUsername());
    System.out.println(fakeDataSource.getPassword());
    System.out.println(fakeDataSource.getJdbcurl());
  }
}

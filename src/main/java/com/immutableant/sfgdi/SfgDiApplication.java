package com.immutableant.sfgdi;

import com.immutableant.sfgdi.controllers.ConstructorInjectedController;
import com.immutableant.sfgdi.controllers.MyController;
import com.immutableant.sfgdi.controllers.PropertyInjectedController;
import com.immutableant.sfgdi.controllers.SetterInjectedController;
import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(bean -> System.out.println(bean));

		System.out.println("------ PRIMARY Bean");
		MyController myController = (MyController)  ctx.getBean("myController");

		System.out.println(myController.sayHello());

		System.out.println("------ Property based");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("------ Setter based");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------ Constructor based");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());


	}

}

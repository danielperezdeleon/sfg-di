package com.immutableant.sfgdi.config;

import com.immutableant.sfgdi.repositories.EnglishGreetingRepository;
import com.immutableant.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.immutableant.sfgdi.repositories.datasource.FakeDataSource;
import com.immutableant.sfgdi.services.*;
import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

  @Bean
  FakeDataSource fakeDataSource(
      @Value("${guru.username}") String username,
      @Value("${guru.password}") String password,
      @Value("${guru.jdbcurl}") String jdbcurl) {
    FakeDataSource fakeDataSource = new FakeDataSource();
    fakeDataSource.setUsername(username);
    fakeDataSource.setPassword(password);
    fakeDataSource.setJdbcurl(jdbcurl);
    return fakeDataSource;
  }

  @Bean
  PetServiceFactory petServiceFactory() {
    return new PetServiceFactory();
  }

  @Profile({"dog", "default"})
  @Bean
  PetService dogPetService(PetServiceFactory petServiceFactory) {
    return petServiceFactory.getPetService("dog");
  }

  @Bean
  @Profile("cat")
  PetService catPetService(PetServiceFactory petServiceFactory) {
    return petServiceFactory.getPetService("cat");
  }

  @Profile({"ES", "default"})
  @Bean("i18nService")
  I18nSpanishGreetingService i18NSpanishService() {
    return new I18nSpanishGreetingService();
  }

  @Bean
  EnglishGreetingRepository englishGreetingRepository() {
    return new EnglishGreetingRepositoryImpl();
  }

  @Profile("EN")
  @Bean
  I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository) {
    return new I18nEnglishGreetingService(englishGreetingRepository);
  }

  @Primary
  @Bean
  PrimaryGreetingService primaryGreetingService() {
    return new PrimaryGreetingService();
  }

  @Bean
  PropertyInjectedGreetingService propertyInjectedGreetingService() {
    return new PropertyInjectedGreetingService();
  }

  @Bean
  SetterGreetingServiceImpl setterInjectedGreetingService() {
    return new SetterGreetingServiceImpl();
  }
}

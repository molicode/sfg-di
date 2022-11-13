package molicode.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import molicode.springframework.sfgdi.repositories.EnglishGreetingRepository;
import molicode.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import molicode.springframework.sfgdi.services.ConstructorGreetingService;
import molicode.springframework.sfgdi.services.I18nEnglishGreetingService;
import molicode.springframework.sfgdi.services.I18nSpanishGreetingService;
import molicode.springframework.sfgdi.services.PropertyGreetingService;
import molicode.springframework.sfgdi.services.SetterGreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

  @Bean
  PetServiceFactory petServiceFactory() {
    return new PetServiceFactory();
  }

  @Profile({"dog", "default"})
  @Bean
  PetService dogService(PetServiceFactory petServiceFactory) {
    return petServiceFactory.getPetSerervice("dog");
  }

  @Profile("cat")
  @Bean
  PetService catService(PetServiceFactory petServiceFactory) {
    return petServiceFactory.getPetSerervice("cat");
  }

  @Profile({"ES", "default"})
  @Bean("i18nService")
  I18nSpanishGreetingService i18SpanishService() {
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

//  @Bean
//  ConstructorGreetingService constructorGreetingService() {
//    return new ConstructorGreetingService();
//  }

  @Bean
  PropertyGreetingService propertyGreetingService() {
    return new PropertyGreetingService();
  }

  @Bean
  SetterGreetingService setterGreetingService() {
    return new SetterGreetingService();
  }

}

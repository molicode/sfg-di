package molicode.springframework.sfgdi.services;

import molicode.springframework.sfgdi.repositories.EnglishGreetingRepository;

public class I18nEnglishGreetingService implements GreetingService {

  private final EnglishGreetingRepository englishGreetingRepository;

  public I18nEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
    this.englishGreetingRepository = englishGreetingRepository;
  }

  @Override
  public String sayGreeting() {
    return "Hello World - EN";
  }
}

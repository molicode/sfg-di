package molicode.springframework.sfgdi.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository {

  @Override
  public String getGreeting() {
    return "HEllo World - EN";
  }

}

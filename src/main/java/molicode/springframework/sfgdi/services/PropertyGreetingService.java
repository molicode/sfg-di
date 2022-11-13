package molicode.springframework.sfgdi.services;

//@Service
public class PropertyGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello World - Property";
  }
}
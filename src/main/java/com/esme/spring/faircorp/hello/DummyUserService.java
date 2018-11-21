package com.esme.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class DummyUserService implements UserService{
    @Autowired
    GreetingService greetingService ;

    @Override
    public void greetAll() {
        List<String> Users = Arrays.asList("Elodie", "Charles");
        Users.forEach(i -> greetingService.greet(i));
    }

}

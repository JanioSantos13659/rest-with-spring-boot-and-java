package br.com.treinamento;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	private static final String tempalte = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
    public Greeting greting(@RequestParam (value = "name", defaultValue = "World")String name) {

		return new Greeting(counter.incrementAndGet(), String.format(tempalte, name));
	}

}
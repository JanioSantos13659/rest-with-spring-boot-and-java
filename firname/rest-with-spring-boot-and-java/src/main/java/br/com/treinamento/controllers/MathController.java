package br.com.treinamento.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.conveter.MathConverter;
import br.com.treinamento.exception.ResurceNotFoundException;
import br.com.treinamento.math.SimpleMath;

@RestController
public class MathController {
	
    
	
	private SimpleMath math = new SimpleMath();
    
     
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
		) throws Exception{
		
		if(!MathConverter.isNumeric(numberOne) || !MathConverter.isNumeric(numberTwo)) {
			throw new ResurceNotFoundException("Please set a numeric value!");
		}
		return math.multiplication(MathConverter.convertToDouble(numberOne), MathConverter.convertToDouble(numberTwo));
	}
    
  

}

package br.com.treinamento.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.treinamento.data.vo.v2.PersonVOV2;
import br.com.treinamento.model.Person;

@Service
public class PersonMapper {
	
	public PersonVOV2 conveterEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthday(new Date());
		vo.setFirnName(person.getFirnName());
		vo.setLastName(person.getLastName());
		vo.setGenter(person.getGenter());
		
		return vo;
	}
	
	public Person conveterVoToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		entity.setFirnName(person.getFirnName());
		entity.setLastName(person.getLastName());
		entity.setGenter(person.getGenter());
		//entity.setBirthday(new Date());
		
		return entity;
	}


}

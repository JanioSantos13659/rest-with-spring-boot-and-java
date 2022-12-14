package br.com.treinamento.services;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.treinamento.data.vo.v1.PersonVO;
import br.com.treinamento.data.vo.v2.PersonVOV2;
import br.com.treinamento.exception.ResurceNotFoundException;
import br.com.treinamento.mapper.DozerMapper;
import br.com.treinamento.mapper.custom.PersonMapper;
import br.com.treinamento.model.Person;
import br.com.treinamento.repository.PersonRepository;



@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	
	@Autowired
    PersonRepository repository;
	
	@Autowired
    PersonMapper mapper;
	
	
	public List<PersonVO> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		
		logger.info("Finding one person!");
		
		var entity =  repository.findById(id)
			.orElseThrow(() -> new ResurceNotFoundException("No records found for this ID!"));
	
	  return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {

		logger.info("Creating one person!");
		
		var entity = DozerMapper.parseObject(person, Person.class);
	    var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
	    
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		
		logger.info("Updating one person!");
		
		var entity = repository.findById(person.getId())
			.orElseThrow(() -> new ResurceNotFoundException("No records found for this ID!"));

		entity.setFirnName(person.getFirnName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGenter(person.getGenter());
		 
		var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		 
		return vo;
     }
	
	public void delete(Long id) {
		
		logger.info("Deleting one person!");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResurceNotFoundException("No records found for this ID!"));
		repository.delete(entity);
	}

	public PersonVOV2 createV2(PersonVOV2 person) {
             
		logger.info("Creating one person!");
		
		var entity = mapper.conveterVoToEntity(person);
	    var vo = mapper.conveterEntityToVo(repository.save(entity));
	    
		return vo;
	}
}

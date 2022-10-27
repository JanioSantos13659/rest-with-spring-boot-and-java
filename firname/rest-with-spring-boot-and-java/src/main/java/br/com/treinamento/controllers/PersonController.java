package br.com.treinamento.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.treinamento.data.vo.v1.PersonVO;
import br.com.treinamento.data.vo.v2.PersonVOV2;
import br.com.treinamento.services.PersonServices;
import br.com.treinamento.util.mediaType;

@RestController
@RequestMapping("/person/v1")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
    @GetMapping(value = "/{id}", produces = {mediaType.APPLICATION_JSON, mediaType.APPLICATION_XML, mediaType.APPLICATION_YML})
    public PersonVO findById(@PathVariable (value = "id")Long id) throws Exception {
    	
    	return service.findById(id);
    }
    
    @GetMapping(produces = {mediaType.APPLICATION_JSON, mediaType.APPLICATION_XML, mediaType.APPLICATION_YML})
	
    public List<PersonVO> findAll(){
    	
    	return service.findAll();
    }
  
    @PostMapping(consumes = {mediaType.APPLICATION_JSON, mediaType.APPLICATION_XML, mediaType.APPLICATION_YML}, produces = {mediaType.APPLICATION_JSON, mediaType.APPLICATION_XML, mediaType.APPLICATION_YML} )
    public PersonVO create(@RequestBody PersonVO person) {

    	return service.create(person);
    }
    
    @PostMapping(value = "/v2", consumes = {mediaType.APPLICATION_JSON, mediaType.APPLICATION_XML, mediaType.APPLICATION_YML}, produces = {mediaType.APPLICATION_JSON, mediaType.APPLICATION_XML, mediaType.APPLICATION_YML})
    public PersonVOV2 createV2(@RequestBody PersonVOV2 personv2) {

    	return service.createV2(personv2);
    }


    @PutMapping(consumes = {mediaType.APPLICATION_JSON, mediaType.APPLICATION_XML, mediaType.APPLICATION_YML}, produces = {mediaType.APPLICATION_JSON, mediaType.APPLICATION_XML, mediaType.APPLICATION_YML})
    public PersonVO uptade(@RequestBody PersonVO person) {

    	return service.update(person);
    }

    @DeleteMapping(value = "/{id}", produces = {mediaType.APPLICATION_JSON, mediaType.APPLICATION_XML, mediaType.APPLICATION_YML})
    public ResponseEntity<?> delete(@PathVariable (value = "id")long id) {
    	service.delete(id);    	
    	return ResponseEntity.noContent().build(); //Retornando Status 204
    }

}

package br.com.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.treinamento.data.vo.v1.PersonVO;
import br.com.treinamento.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}

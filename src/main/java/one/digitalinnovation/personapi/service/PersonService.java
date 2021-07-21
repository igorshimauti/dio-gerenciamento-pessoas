package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public List<Person> read() {
        return personRepository.findAll();
    }

    public Person readById(Long personId) throws PersonNotFoundException {
        return personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException(personId));
    }

    public Person update(Long personId, Person person) throws PersonNotFoundException {
        if (!personRepository.existsById(personId))
            throw new PersonNotFoundException(personId);

        person.setId(personId);
        return personRepository.save(person);
    }

    public void delete(Long personId) throws PersonNotFoundException {
        if (!personRepository.existsById(personId))
            throw new PersonNotFoundException(personId);

        personRepository.deleteById(personId);
    }


}
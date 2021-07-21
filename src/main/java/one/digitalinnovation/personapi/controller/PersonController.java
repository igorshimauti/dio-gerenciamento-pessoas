package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.model.dto.PersonDto;
import one.digitalinnovation.personapi.model.mapper.PersonMapper;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonMapper personMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PersonDto> create(@Valid @RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personMapper.toDto(personService.create(personMapper.toEntity(personDto))));
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> read() {
        return ResponseEntity.ok(personMapper.toCollectionDto(personService.read()));
    }

    @GetMapping(value = "/{personId}")
    public ResponseEntity<PersonDto> readById(@PathVariable Long personId) throws PersonNotFoundException {
        PersonDto personDto = personMapper.toDto(personService.readById(personId));
        return ResponseEntity.ok(personDto);
    }

    @PutMapping(value = "/{personId}")
    public ResponseEntity<PersonDto> update(@PathVariable Long personId, @Valid @RequestBody PersonDto personDto) throws PersonNotFoundException {
        return ResponseEntity.ok(personMapper.toDto(personService.update(personId, personMapper.toEntity(personDto))));
    }

    @DeleteMapping(value = "/{personId}")
    public ResponseEntity<Void> delete(@PathVariable Long personId) throws PersonNotFoundException {
        personService.delete(personId);
        return ResponseEntity.noContent().build();
    }
}
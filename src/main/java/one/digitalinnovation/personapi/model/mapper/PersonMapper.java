package one.digitalinnovation.personapi.model.mapper;

import one.digitalinnovation.personapi.model.Person;
import one.digitalinnovation.personapi.model.dto.PersonDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PersonDto toDto(Person person) {
        return modelMapper.map(person, PersonDto.class);
    }

    public List<PersonDto> toCollectionDto(List<Person> persons) {
        return persons.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Person toEntity(PersonDto personDto) {
        return modelMapper.map(personDto, Person.class);
    }
}

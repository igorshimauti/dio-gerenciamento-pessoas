package one.digitalinnovation.personapi.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 150)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 150)
    private String lastName;

    @NotBlank
    @CPF
    private String cpf;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthData;

    @NotEmpty
    private List<PhoneDto> phones;
}
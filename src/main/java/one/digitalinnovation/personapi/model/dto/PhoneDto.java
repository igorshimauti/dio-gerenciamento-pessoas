package one.digitalinnovation.personapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.model.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDto {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    @NotBlank
    @Size(min = 13, max = 14)
    private String number;
}
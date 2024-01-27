package it.home.sample.api.dto;

import it.home.starter.controller.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto extends BaseDto {

    private String firstname;
    private String surname;
}

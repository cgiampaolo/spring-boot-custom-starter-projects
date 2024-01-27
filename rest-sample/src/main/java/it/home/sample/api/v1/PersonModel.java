package it.home.sample.api.v1;

import it.home.starter.controller.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel extends BaseModel {

    private String firstname;
    private String surname;
}

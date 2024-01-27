package it.home.starter.controller.dto;

import it.home.starter.pojo.FilterCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterCriteriaDto {

    private List<FilterCriteria> filterCriteriaList;
    private String booleanOperator;

}

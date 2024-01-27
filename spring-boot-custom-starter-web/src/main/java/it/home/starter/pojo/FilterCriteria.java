package it.home.starter.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilterCriteria {

    private String filterKey;
    private Object value;
    private String operation;
    @JsonIgnore
    private String dataOption;

    public FilterCriteria(String filterKey, String operation,
                          Object value) {
        super();
        this.filterKey = filterKey;
        this.operation = operation;
        this.value = value;
    }

}

package it.home.starter.controller.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BasePage<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 7677795477542296548L;

    private BasePageable pageable;
    private List<T> data;

    @Data
    @Builder
    public static class BasePageable implements Serializable {
        private static final long serialVersionUID = -6463568067770602034L;
        private Integer totalElements;
        private int page;
        private int size;
    }
}
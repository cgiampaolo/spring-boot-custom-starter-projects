package it.home.starter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.home.starter.controller.dto.DeletedResponseDto;
import it.home.starter.controller.dto.FilterCriteriaDto;
import it.home.starter.controller.dto.BaseDto;
import it.home.starter.controller.page.BasePage;
import jakarta.validation.Valid;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Validated
public interface BaseRestFullController<T extends BaseDto> {

    ResponseEntity<List<T>> list();

    ResponseEntity<List<T>> list(FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException;

    ResponseEntity<T> create(@RequestBody @Valid T dto);

    ResponseEntity<List<T>> postBulk(@RequestBody @Valid List<T> dto);

    ResponseEntity<T> update(@PathVariable String id, @RequestBody T dto);

    ResponseEntity<DeletedResponseDto> delete(@RequestBody List<String> id);

    ResponseEntity<DeletedResponseDto> deleteAll();

    ResponseEntity<Integer> count(@RequestBody FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException;

    ResponseEntity<T> get(@PathVariable(value = "id") String id);

    ResponseEntity<Resource> export(String format, List<String> objectIds) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    ResponseEntity<BasePage<T>> filter(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                       @RequestParam(name = "size", defaultValue = "5") Integer size,
                                       @RequestParam(name = "sort", defaultValue = "DESC") String sort,
                                       @RequestBody FilterCriteriaDto
                                               filterCriteriaDto) throws JsonProcessingException;
}

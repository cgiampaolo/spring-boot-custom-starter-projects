package it.home.starter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.home.starter.controller.dto.BaseDto;
import it.home.starter.controller.dto.DeletedResponseDto;
import it.home.starter.controller.dto.FilterCriteriaDto;
import it.home.starter.controller.page.BasePage;
import it.home.starter.service.BaseService;
import jakarta.validation.Valid;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface BaseRestController<T extends BaseService> {

    @GetMapping("/")
    ResponseEntity<List<BaseDto>> list();

    ResponseEntity<List<BaseDto>> list(FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException;

    @PostMapping("/")
    ResponseEntity<BaseDto> create(@RequestBody @Valid BaseDto dto);

    @PostMapping("/postBulk")
    ResponseEntity<List<BaseDto>> postBulk(@RequestBody @Valid List<BaseDto> dtoList);

    @PatchMapping("/{id}")
    ResponseEntity<BaseDto> update(@PathVariable String id, @RequestBody BaseDto dto);


    @DeleteMapping("/")
    ResponseEntity<DeletedResponseDto> delete(@RequestBody List<String> idList);
    @DeleteMapping("/all")
    ResponseEntity<DeletedResponseDto> deleteAll();

    @PostMapping("/count")
    ResponseEntity<Integer> count(@RequestBody FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException;

    ResponseEntity<BaseDto> get(@PathVariable(value = "id") String id);

    @GetMapping("/{id}")
    ResponseEntity<Resource> export(String format, List<String> idList) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;


    @PostMapping(value = "/export/{format}")
    ResponseEntity<BasePage<BaseDto>> filter(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                       @RequestParam(name = "size", defaultValue = "5") Integer size,
                                       @RequestParam(name = "sort", defaultValue = "DESC") String sort,
                                       @RequestBody FilterCriteriaDto
                                               filterCriteriaDto) throws JsonProcessingException;
}

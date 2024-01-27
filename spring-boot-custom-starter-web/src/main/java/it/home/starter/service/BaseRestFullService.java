package it.home.starter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.home.starter.controller.dto.DeletedResponseDto;
import it.home.starter.controller.dto.FilterCriteriaDto;
import it.home.starter.controller.dto.BaseDto;
import it.home.starter.controller.page.BasePage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface BaseRestFullService<T extends BaseDto>{

    List<T> list();

    List<T> list(String filterString) ;

    T create(T dto);

    List<T> postBulk(List<T> dto);

    T update(@PathVariable String id, T dto);

    DeletedResponseDto delete(@PathVariable String id);

    T get(@PathVariable(value = "id") String id);

    Integer count(FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException;

    DeletedResponseDto delete(List<String> objectIdList);

    DeletedResponseDto deleteAll();

    ByteArrayResource generateXLSXObject(Class<?> type, List<String> objectIds) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    ByteArrayResource generateCSVObject(Class<?> type, List<String> objectIds) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    BasePage<T> getAllPageableFiltered(FilterCriteriaDto filterCriteriaDto, Integer pageSize, Integer pageNumber) throws JsonProcessingException;

}

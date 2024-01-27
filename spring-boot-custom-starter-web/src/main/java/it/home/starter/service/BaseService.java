package it.home.starter.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.home.starter.controller.dto.BaseDto;
import it.home.starter.controller.dto.DeletedResponseDto;
import it.home.starter.controller.dto.FilterCriteriaDto;
import it.home.starter.controller.page.BasePage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface BaseService{

    List<BaseDto> list();

    List<BaseDto> list(String filterString) ;

    BaseDto create(BaseDto dto);

    List<BaseDto> postBulk(List<BaseDto> dtoList);

    BaseDto update(@PathVariable String id, BaseDto dto);

    DeletedResponseDto delete(@PathVariable String id);

    BaseDto get(@PathVariable(value = "id") String id);

    Integer count(FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException;

    DeletedResponseDto delete(List<String> idList);

    DeletedResponseDto deleteAll();

    ByteArrayResource generateXLSXObject(Class<BaseDto> type, List<String> idList) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    ByteArrayResource generateCSVObject(Class<BaseDto> type, List<String> idList) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException;

    BasePage<BaseDto> getAllPageableFiltered(FilterCriteriaDto filterCriteriaDto, Integer pageSize, Integer pageNumber) throws JsonProcessingException;

}

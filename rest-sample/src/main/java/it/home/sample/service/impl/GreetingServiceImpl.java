package it.home.sample.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.home.sample.api.dto.PersonDto;
import it.home.sample.service.GreetingService;
import it.home.starter.controller.dto.DeletedResponseDto;
import it.home.starter.controller.dto.FilterCriteriaDto;
import it.home.starter.controller.page.BasePage;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public List<PersonDto> list() {
        return null;
    }

    @Override
    public List<PersonDto> list(String filterString) {
        return null;
    }

    @Override
    public PersonDto create(PersonDto dto) {
        return null;
    }

    @Override
    public List<PersonDto> postBulk(List<PersonDto> dto) {
        return null;
    }

    @Override
    public PersonDto update(String id, PersonDto dto) {
        return null;
    }

    @Override
    public DeletedResponseDto delete(String id) {
        return null;
    }

    @Override
    public PersonDto get(String id) {
        return null;
    }

    @Override
    public Integer count(FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public DeletedResponseDto delete(List<String> objectIdList) {
        return null;
    }

    @Override
    public DeletedResponseDto deleteAll() {
        return null;
    }

    @Override
    public ByteArrayResource generateXLSXObject(Class<?> type, List<String> objectIds) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return null;
    }

    @Override
    public ByteArrayResource generateCSVObject(Class<?> type, List<String> objectIds) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return null;
    }

    @Override
    public BasePage<PersonDto> getAllPageableFiltered(FilterCriteriaDto filterCriteriaDto, Integer pageSize, Integer pageNumber) throws JsonProcessingException {
        return null;
    }
}

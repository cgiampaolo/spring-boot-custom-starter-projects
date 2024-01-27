package it.home.starter.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.home.starter.controller.dto.BaseDto;
import it.home.starter.controller.dto.DeletedResponseDto;
import it.home.starter.controller.dto.FilterCriteriaDto;
import it.home.starter.controller.page.BasePage;
import it.home.starter.service.BaseService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
@Service
public class BaseServiceImpl implements BaseService {

    @Override
    public List<BaseDto> list() {
        return null;
    }

    @Override
    public List<BaseDto> list(String filterString) {
        return null;
    }

    @Override
    public BaseDto create(BaseDto dto) {
        return null;
    }

    @Override
    public List<BaseDto> postBulk(List<BaseDto> dtoList) {
        return null;
    }

    @Override
    public BaseDto update(String id, BaseDto dto) {
        return null;
    }

    @Override
    public DeletedResponseDto delete(String id) {
        return null;
    }

    @Override
    public BaseDto get(String id) {
        return null;
    }

    @Override
    public Integer count(FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public DeletedResponseDto delete(List<String> idList) {
        return null;
    }

    @Override
    public DeletedResponseDto deleteAll() {
        return null;
    }

    @Override
    public Resource export(String format, List<String> objectIds) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return null;
    }

    @Override
    public BasePage<BaseDto> getAllPageableFiltered(FilterCriteriaDto filterCriteriaDto, Integer pageSize, Integer pageNumber) throws JsonProcessingException {
        return null;
    }
}

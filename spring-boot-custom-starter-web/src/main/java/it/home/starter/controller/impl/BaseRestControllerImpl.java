package it.home.starter.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.home.starter.controller.BaseRestController;
import it.home.starter.controller.dto.BaseDto;
import it.home.starter.controller.dto.DeletedResponseDto;
import it.home.starter.controller.dto.FilterCriteriaDto;
import it.home.starter.controller.page.BasePage;
import it.home.starter.service.BaseService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class BaseRestControllerImpl<T extends BaseService> implements BaseRestController<T> {

    private final BaseService baseService;

    public BaseRestControllerImpl(BaseService baseService) {
        this.baseService = baseService;
    }

    @Override
    public ResponseEntity<List<BaseDto>> list() {
        return ResponseEntity.ok(baseService.list());
    }

    @Override
    public ResponseEntity<List<BaseDto>> list(FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public ResponseEntity<BaseDto> create(BaseDto dto) {
        return ResponseEntity.ok(baseService.create(dto));
    }

    @Override
    public ResponseEntity<List<BaseDto>> postBulk(List<BaseDto> dtoList) {
        return ResponseEntity.ok(dtoList);
    }

    @Override
    public ResponseEntity<BaseDto> update(String id, BaseDto dto) {
        return ResponseEntity.ok(baseService.update(id,dto));
    }

    @Override
    public ResponseEntity<DeletedResponseDto> delete(List<String> idList) {
        return ResponseEntity.ok(baseService.delete(idList));
    }

    @Override
    public ResponseEntity<DeletedResponseDto> deleteAll() {
        return ResponseEntity.ok(baseService.deleteAll());
    }

    @Override
    public ResponseEntity<Integer> count(FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException {
        return ResponseEntity.ok(baseService.count(filterCriteriaDto));
    }

    @Override
    public ResponseEntity<BaseDto> get(String id) {
        return ResponseEntity.ok(baseService.get(id));
    }

    @Override
    public ResponseEntity<Resource> export(String format, List<String> idList) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return ResponseEntity.ok(baseService.export(format,idList));
    }
    @Override
    public ResponseEntity<BasePage<BaseDto>> filter(Integer pageNumber, Integer pageSize, String sort, FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException {
        return ResponseEntity.ok(baseService.getAllPageableFiltered(filterCriteriaDto,pageSize,pageNumber));
    }
}

package it.home.starter.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.home.starter.controller.BaseRestFullController;
import it.home.starter.controller.dto.DeletedResponseDto;
import it.home.starter.controller.dto.FilterCriteriaDto;
import it.home.starter.controller.dto.BaseDto;
import it.home.starter.controller.page.BasePage;
import it.home.starter.service.BaseRestFullService;
import it.home.starter.utils.FilterUtils;
import jakarta.validation.Valid;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BaseRestFullControllerImpl<T extends BaseDto> implements BaseRestFullController<T> {

    private final BaseRestFullService<T> service;

    public BaseRestFullControllerImpl(BaseRestFullService<T> service) {
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<T>> list() {

        return ResponseEntity.ok(service.list());
    }

    @Override
    public ResponseEntity<List<T>> list(FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException {
        return ResponseEntity.ok(service.list(
                FilterUtils.convertOperationInJson(filterCriteriaDto.getFilterCriteriaList(), filterCriteriaDto.getBooleanOperator())));
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<T> create(@RequestBody @Valid T entity) {
        return  ResponseEntity.ok(service.create(entity));
    }
    @Override
    @PostMapping("/postBulk")
    public ResponseEntity<List<T>> postBulk(List<T> dto) {
        return ResponseEntity.ok(service.postBulk(dto));
    }
    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable String id, @RequestBody T dto) {
        return  ResponseEntity.ok(service.update(id,dto));
    }
    @Override
    @DeleteMapping("/")
    public ResponseEntity<DeletedResponseDto> delete(@RequestBody List<String> id) {
        return ResponseEntity.ok(service.delete(id));
    }
    @Override
    @DeleteMapping("/all")
    public ResponseEntity<DeletedResponseDto> deleteAll() {
        return ResponseEntity.ok(service.deleteAll());
    }

    @Override
    @PostMapping("/count")
    public ResponseEntity<Integer> count(FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException {
        return ResponseEntity.ok(service.count(filterCriteriaDto));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<T> get(@PathVariable(value = "id") String id) {
        return  ResponseEntity.ok(service.get(id));
    }

    @Override
    @PostMapping(value = "/export/{format}")
    public ResponseEntity<Resource> export(@PathVariable String format, @RequestBody List<String> objectIds) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        Class<T> tClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseRestFullController.class);
        ByteArrayResource byteArrayResource;
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormatter.format(new Date());
        String filename = "export_"+tClass.getSimpleName() +"_" +currentDateTime;

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename + ".xlsx");
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        switch (format.toLowerCase()){
            case "xlsx":
                byteArrayResource = service.generateXLSXObject(tClass, objectIds);
                break;
            case "csv":
                byteArrayResource = service.generateCSVObject(tClass , objectIds);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + format);
        }

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(byteArrayResource);
    }

    @Override
    @PostMapping("/filter")
    public ResponseEntity<BasePage<T>> filter(Integer pageNumber, Integer pageSize, String sort, FilterCriteriaDto filterCriteriaDto) throws JsonProcessingException {
        return ResponseEntity.ok(service.getAllPageableFiltered(filterCriteriaDto,pageSize,pageNumber));
    }
}

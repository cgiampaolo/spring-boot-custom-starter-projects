package it.home.starter.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.home.starter.controller.dto.BaseDto;
import it.home.starter.controller.model.BaseModel;
import it.home.starter.repository.BaseRepository;
import it.home.starter.service.BaseServiceJpa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseServiceJpaImpl<T extends BaseServiceJpa, S extends BaseModel> extends BaseServiceImpl {

    ObjectMapper objectMapper = new ObjectMapper();

    private BaseRepository<S> baseRepository;

    @Override
    public List<BaseDto> list() {
        return null;
    }
}

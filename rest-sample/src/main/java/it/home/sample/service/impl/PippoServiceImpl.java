package it.home.sample.service.impl;

import it.home.sample.api.dto.PersonDto;
import it.home.sample.service.PippoService;
import it.home.starter.controller.dto.BaseDto;
import it.home.starter.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PippoServiceImpl extends BaseServiceImpl implements PippoService {

    @Override
    public List<BaseDto> list() {
        return List.of(PersonDto.builder().firstname("claudio").surname("giampaolo").build());
    }
}

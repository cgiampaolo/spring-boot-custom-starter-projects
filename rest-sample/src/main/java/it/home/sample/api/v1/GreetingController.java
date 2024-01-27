package it.home.sample.api.v1;

import it.home.sample.api.dto.PersonDto;
import it.home.sample.service.GreetingService;
import it.home.starter.controller.impl.BaseRestFullControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/greeting")
public class GreetingController extends BaseRestFullControllerImpl<PersonDto> {

    private final GreetingService greetingService;


    public GreetingController(GreetingService greetingService) {
        super(greetingService);
        this.greetingService = greetingService;
    }
}


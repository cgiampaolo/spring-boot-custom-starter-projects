package it.home.sample.api.v2;

import it.home.sample.service.PippoService;
import it.home.starter.controller.impl.BaseRestControllerImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v2/pippo")
@RestController
public class PippoController extends BaseRestControllerImpl<PippoService>  {

    private final PippoService pippoService;

    public PippoController(PippoService pippoService) {
        super(pippoService);
        this.pippoService = pippoService;
    }
}

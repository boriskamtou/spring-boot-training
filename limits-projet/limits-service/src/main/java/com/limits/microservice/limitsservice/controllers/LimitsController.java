package com.limits.microservice.limitsservice.controllers;

import com.limits.microservice.limitsservice.configs.Configs;
import com.limits.microservice.limitsservice.entities.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    private final Configs configs;

    public LimitsController(Configs configs) {
        this.configs = configs;
    }

    @GetMapping("/limits")
    public Limits getLimits() {
        return new Limits(configs.getMinimum(), configs.getMaximum());
    }
}

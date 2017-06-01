package ru.nevars.example.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
@RequestMapping(value = "/statistic",
        consumes = {TEXT_PLAIN_VALUE, APPLICATION_JSON_VALUE},
        produces = {APPLICATION_JSON_VALUE})
public class StatisticService {
}

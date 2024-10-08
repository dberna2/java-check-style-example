package com.dberna2.checkstyle.javacheckstyleexample.controller;

import com.dberna2.checkstyle.javacheckstyleexample.repository.HelloRepository;
import org.springframework.web.bind.annotation.*;


@RestController
public class ExampleController {

  private final HelloRepository helloRepository;

  public ExampleController(final HelloRepository helloRepository) {
    this.helloRepository = helloRepository;
  }

  @GetMapping
  public String hello__controller() {
    return helloRepository.hello();
  }
}

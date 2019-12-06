package com.dashboard.web.v1.controller;

import com.dashboard.exception.BadRequestException;
import com.dashboard.model.Config;
import com.dashboard.service.ConfigService;
import com.dashboard.web.v1.response.Response;
import com.dashboard.web.v1.transport.V1Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/config")
public class ConfigController {

  @Autowired
  public ConfigService configService;

  @GetMapping("{id}")
  public ResponseEntity<Response<V1Config>> get(@Valid @PathVariable("id") String id) {
    Response response = new Response();
    response.setData(new V1Config(configService.get(id)));

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping()
  public ResponseEntity<?> listAll(Pageable pageable) {
    Page<V1Config> allConfig = new PageImpl(configService.listAll(pageable));

    return ResponseEntity.status(HttpStatus.OK).body(allConfig);
  }

  @PostMapping
  public ResponseEntity<Response<V1Config>> create(@Valid @RequestBody V1Config v1Config,
      BindingResult result) {
    v1Config = new V1Config(configService.create(v1Config.toConfig(), result));
    Response response = new Response();
    response.setData(v1Config);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Response<V1Config>> update(@PathVariable String id,
      @Valid @RequestBody V1Config v1Config, BindingResult result) {
    v1Config = new V1Config(configService.update(id, v1Config.toConfig(), result));

    Response response = new Response();
    response.setData(v1Config);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable String id) {
    Response response = new Response();

    if (configService.delete(id)) {
      response.getErrors().add("Config deleted!");
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    response.getErrors().add("Its not possible to delete the config!");
    throw new BadRequestException(response);
  }
}

package com.dashboard.service;

import com.dashboard.exception.BadRequestException;
import com.dashboard.exception.NotFoundException;
import com.dashboard.model.Config;
import com.dashboard.repository.ConfigRepository;
import com.dashboard.web.v1.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class ConfigService {

  @Autowired
  private ConfigRepository configRepository;

  public Config get(String id) {
    Optional<Config> config = configRepository.findById(id);

    if (!config.isPresent()) {
      Response<Config> response = new Response<>();
      response.getErrors().add("Config not found!");
      throw new NotFoundException(response);
    }

    return config.get();
  }

  public List<Config> listAll(Pageable pageable) {
    List<Config> allConfig = configRepository.findAll(pageable).getContent();

    if (allConfig.isEmpty()) {
      Response response = new Response();
      response.getErrors().add("Configs not found!");
      throw new NotFoundException(response);
    }

    return allConfig;
  }

  public Config create(Config config, BindingResult result) {
    if (result.hasErrors()) {
      Response<Config> response = new Response<>();
      result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
      throw new BadRequestException(response);
    }

    configRepository.save(config);
    return config;
  }


  public Config update(String id, Config config, BindingResult result) {
    Response<Config> response = new Response<>();

    if (result.hasErrors()) {
      result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
      throw new BadRequestException(response);
    }

    Optional<Config> configEntity = configRepository.findById(id);

    if (!configEntity.isPresent()) {
      response.getErrors().add("Config " + id + " not found!");
      throw new NotFoundException(response);
    }

    configEntity.get().setActive(config.isActive());
    configEntity.get().setCity(config.getCity());
    configEntity.get().setHealthUrl(config.getHealthUrl());
    configEntity.get().setMachineIp(config.getMachineIp());
    configEntity.get().setName(config.getName());
    configEntity.get().setPeriod(config.getPeriod());
    configEntity.get().setState(config.getState());

    configRepository.save(configEntity.get());

    return configEntity.get();
  }

  public Boolean delete(String id) {
    Response<Config> response = new Response<>();
    Optional<Config> config = configRepository.findById(id);

    if (!config.isPresent()) {
      response.getErrors().add("Config " + id + " not found!");
      throw new NotFoundException(response);
    }

    response.setData(config.get());
    configRepository.deleteById(id);

    return Boolean.TRUE;
  }

}

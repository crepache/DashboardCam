package com.dashboard.web.v1.transport;

import com.dashboard.model.Config;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;

public class V1Config {

  private String id;

  @NotBlank(message = "Field state shouldn't empty")
  private String state;

  @NotBlank(message = "Field city shouldn't empty")
  private String city;

  @NotBlank(message = "Field name shouldn't empty")
  private String name;

  private int period;

  private boolean active = Boolean.TRUE;

  private String machineIp;

  private String healthUrl;

  public V1Config() {

  }

  public V1Config(Config config) {
    this.state = config.getState().toString();
    this.city = config.getCity();
    this.name = config.getName();
    this.period = config.getPeriod();
    this.active = config.isActive();
    this.machineIp = config.getMachineIp();
    this.healthUrl = config.getHealthUrl();
    this.id = config.getId();
  }

  public String getId() {
    return id;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPeriod() {
    return period;
  }

  public void setPeriod(int period) {
    this.period = period;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getMachineIp() {
    return machineIp;
  }

  public void setMachineIp(String machineIp) {
    this.machineIp = machineIp;
  }

  public String getHealthUrl() {
    return healthUrl;
  }

  public void setHealthUrl(String healthUrl) {
    this.healthUrl = healthUrl;
  }

  public Config toConfig() {
    return new ModelMapper().map(this, Config.class);
  }

}

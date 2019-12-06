package com.dashboard.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "config")
public class Config {

  @Id
  private String id;

  @NotBlank(message = "Field state shouldn't empty")
  private StateEnum state;

  @NotBlank(message = "Field city shouldn't empty")
  private String city;

  @NotBlank(message = "Field name shouldn't empty")
  private String name;

  @NotBlank(message = "Field name shouldn't empty")
  private int period;

  private boolean active = Boolean.TRUE;

  private String machineIp;

  private String healthUrl;

  public Config() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
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
}

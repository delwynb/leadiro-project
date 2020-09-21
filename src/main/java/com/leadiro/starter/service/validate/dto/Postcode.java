package com.leadiro.starter.service.validate.dto;

import lombok.Data;

@Data
public class Postcode {
  private Integer status;
  private Result result;

  @Data
  class Result {
    private String postcode;
    private String region;
  }
}

package com.leadiro.starter.service.validate.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
  private String error;
  private String message;
}

package com.leadiro.starter.service.validate.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Email {
  private String email;
  private boolean valid;
  private String message;
}

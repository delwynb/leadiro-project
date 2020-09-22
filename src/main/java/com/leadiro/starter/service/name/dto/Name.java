package com.leadiro.starter.service.name.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Name {
  private String first;
  private String last;
}

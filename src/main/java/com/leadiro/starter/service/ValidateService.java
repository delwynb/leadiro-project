package com.leadiro.starter.service;

import com.leadiro.starter.service.validate.dto.Email;

public interface ValidateService {

  /** Validate email format */
  Email validateEmailFormat(String email);

  /** Validate UK postcode */
  Object validateUKPostCode(String postcode);
}

package com.leadiro.starter.service.validate;

import com.leadiro.starter.service.ValidateService;
import com.leadiro.starter.service.validate.dto.Email;
import com.leadiro.starter.service.validate.dto.ErrorMessage;
import com.leadiro.starter.service.validate.dto.Postcode;
import com.leadiro.starter.service.validate.dto.ValidPostcode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.util.Objects.nonNull;

@Service
@Slf4j
public class ConcreteValidateService implements ValidateService {

  private final RestTemplate restTemplate = new RestTemplate();

  @Override
  public Email validateEmailFormat(String email) {
    boolean valid = EmailUtil.isValid(email);
    return Email.builder()
        .email(email)
        .valid(valid)
        .message(valid ? "This is a valid email" : "Invalid email provided")
        .build();
  }

  @Override
  public Object validateUKPostCode(String postcode) {
    String POSTCODES_URL = "http://api.postcodes.io/postcodes/:postcode";
    String VALIDATE_POSTCODE_URL = "http://api.postcodes.io/postcodes/:postcode/validate";

    ValidPostcode validPostcode =
        restTemplate.getForObject(
            VALIDATE_POSTCODE_URL.replaceFirst(":postcode", postcode), ValidPostcode.class);

    if (nonNull(validPostcode) && validPostcode.getResult()) {
      Postcode response =
          restTemplate.getForObject(
              POSTCODES_URL.replaceFirst(":postcode", postcode), Postcode.class);

      if (nonNull(response)
          && nonNull(response.getStatus())
          && response.getStatus().equals(200)
          && nonNull(response.getResult())) {
        return response.getResult();
      }
    }

    return ErrorMessage.builder()
        .error("Invalid postcode")
        .message(String.format("%s is invalid UK Post Code", postcode))
        .build();
  }
}

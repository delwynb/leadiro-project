package com.leadiro.starter.service.validate;

public class EmailUtil {

  private static final String EMAIL_REGEX =
      "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";

  public static boolean isValid(String email) {
    return email.matches(EMAIL_REGEX);
  }
}

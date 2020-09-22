package com.leadiro.starter.service.name;

import com.google.common.collect.Lists;
import com.leadiro.starter.service.name.dto.Name;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class NameParser {

  private static final String INVALID_NAME = "Unable to parse this invalid value";

  private final List<String> TITLES =
      Lists.newArrayList(
          "Csar",
          "Dr",
          "Rev.",
          "D.R.",
          "M.BA.",
          "Bsc",
          "Dip Ed",
          "DipEd",
          "MSc",
          "MPH",
          "DRes",
          "PhD",
          "Phd",
          "MacA",
          "assoc prof",
          "Jr.",
          "Certified Professional",
          "II.",
          "III.",
          "IV.");

  private final List<String> INVALID_CHARACTERS =
      Lists.newArrayList("-", "\\|", "\\.", "\\*", "\\/", "~", "'");

  public Name parse(String value) {
    String original = value;

    value = this.removeAlias(value);
    value = this.removeNumbers(value);
    value = this.removeTitles(value);
    value = this.removeInvalidChars(value);
    value = trim(value);

    String[] names = value.split(" ");

    // skip invalid names
    if (names.length == 1) {
      return Name.builder().first(original).last(INVALID_NAME).build();
    }

    Name name = this.build(names);

    return this.validateName(name, original);
  }

  private Name build(String[] names) {
    String last = "";
    String first = "";

    if (names.length > 2) {
      first = names[0];
      last =
          names[names.length - 2].equalsIgnoreCase("Del")
              ? "Del " + capitalize(names[names.length - 1])
              : names[names.length - 1];
    } else {
      // Check last name first *based on comma
      if (names[0].endsWith(",")) {
        last = names[0].substring(0, names[0].length() - 1);
        first = names[1];
      } else {
        last = names[1];
        first = names[0];
      }

      first = capitalize(first);
      last = last.startsWith("de") ? last : capitalize(last);
    }

    // finally remove extra characters
    first = removeCommas(first);
    last = removeCommas(last);

    return Name.builder().first(first).last(last).build();
  }

  private Name validateName(Name name, String original) {
    // final check on validity
    if (name.getFirst().length() < 2 || name.getLast().length() < 2) {
      return Name.builder().first(original).last(INVALID_NAME).build();
    }
    return name;
  }

  private String capitalize(String value) {
    return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
  }

  private String trim(String value) {
    return value.trim().replaceAll(" +", " ");
  }

  private String removeAlias(String value) {
    if (value.contains("a.k.a")) {
      value = value.substring(0, value.indexOf("a.k.a"));
    }
    return value;
  }

  private String removeTitles(String value) {
    for (String title : TITLES) {
      value = this.remove(title, value);
    }
    return value;
  }

  private String removeInvalidChars(String value) {
    for (String invalidChar : INVALID_CHARACTERS) {
      value = this.remove(invalidChar, value);
    }
    return value;
  }

  private String removeNumbers(String value) {
    return value.replaceAll("\\d", "");
  }

  private String removeCommas(String value) {
    return value.replaceAll(",", "");
  }

  private String remove(String substring, String value) {
    return value.replaceAll(substring, "");
  }
}

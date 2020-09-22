package com.leadiro.starter.service;

import com.leadiro.starter.service.name.dto.Name;

import java.util.List;

public interface NameService {

  /** Parse a list of names and returns a list of Name objects */
  List<Name> parseNames(List<String> names);
}

package com.leadiro.starter.service.name;

import com.leadiro.starter.service.NameService;
import com.leadiro.starter.service.name.dto.Name;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ConcreteNameService implements NameService {

  private final NameParser nameParser;

  public ConcreteNameService(NameParser nameParser) {
    this.nameParser = nameParser;
  }

  @Override
  public List<Name> parseNames(List<String> names) {
    return names.stream().map(nameParser::parse).collect(Collectors.toList());
  }
}

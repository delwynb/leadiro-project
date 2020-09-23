package com.leadiro.starter.service.museum;

import com.google.common.collect.Lists;
import com.leadiro.starter.service.MuseumService;
import com.leadiro.starter.service.museum.dto.Record;
import com.leadiro.starter.service.museum.dto.RecordTitle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Slf4j
public class ConcreteMuseumService implements MuseumService {

  private static final String MUSEUMS_BASE_URL = "https://collections.museumsvictoria.com.au";

  private static final String SEARCH_API = "/api/search";
  private static final String ARTICLES_API = "/api/articles/{id}";
  private static final String ITEMS_API = "/api/items/{id}";
  private static final String SPECIES_API = "/api/species/{id}";
  private static final String SPECIMENS_API = "/api/specimens/{id}";

  private static final List<String> RECORD_APIS =
      Lists.newArrayList(ARTICLES_API, ITEMS_API, SPECIES_API, SPECIMENS_API);

  private final RestTemplate restTemplate = new RestTemplate();

  @Override
  public RecordTitle[] search(List<String> keywords) {
    UriComponentsBuilder builder = this.getUriBuilder(SEARCH_API);
    keywords.forEach(keyword -> builder.queryParam("query", keyword));

    URI uri = builder.build().encode().toUri();

    return restTemplate.getForObject(uri, RecordTitle[].class);
  }

  @Override
  public Record getRecordById(String id) {
    Record record = this.findRecordIdFromAPIs(id);

    if (nonNull(record)) {
      return record;
    } else {
      log.info(String.format("Record ID %s not found", id));
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, String.format("Record ID %s not found", id));
    }
  }

  private Record findRecordIdFromAPIs(String id) {
    Record record;

    for (String api : RECORD_APIS) {
      record = getRecord(id, api);

      if (nonNull(record)) {
        return record;
      }
    }

    return null;
  }

  private Record getRecord(String id, String path) {
    UriComponentsBuilder builder = this.getUriBuilder(path);
    URI uri = builder.buildAndExpand(id).encode().toUri();

    Record record = null;
    try {
      record = restTemplate.getForObject(uri, Record.class);
    } catch (Exception e) {
      log.debug(String.format("Record Not Found in %s", path));
    }

    return record;
  }

  private UriComponentsBuilder getUriBuilder(String path) {
    return UriComponentsBuilder.fromUriString(MUSEUMS_BASE_URL).path(path);
  }
}

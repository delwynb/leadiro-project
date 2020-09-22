package com.leadiro.starter.service;

import com.leadiro.starter.service.museum.dto.Record;
import com.leadiro.starter.service.museum.dto.RecordTitle;

import java.util.List;

public interface MuseumService {

  /** Search record titles using the list of keywords */
  RecordTitle[] search(List<String> keywords);

  /** Get record by id */
  Record getRecordById(String id);
}

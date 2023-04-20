package it.learning.learningplatform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface CrudService<Read, Create, Update, ID> {
    List<Read> readAll();
    List<Read> read(Map<String, String> params);
    List<Read> readOne(ID id);
    Read create(Create createDTO);
    Read update(Update updateDTO);
    Read delete(ID id);
}

package it.learning.learningplatform.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface CrudService<Read, Create, Update, ID> {
    List<Read> readAll();
    List<Read> read(Map<String, String> params);
    Read readOne(ID id) throws Exception;
    Read create(Create createDTO);
    Read update(ID id, Update updateDTO) throws Exception;
    String delete(ID id) throws Exception;
}

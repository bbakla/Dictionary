package com.dictionary.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dictionary.model.Name;
import com.dictionary.repository.NameRepository;

@Service
public class NameService {
  
  private NameRepository nameRepository;
  
  @Autowired
  public NameService(NameRepository wordRepository) {
    this.nameRepository = wordRepository;
  }

  public Name saveName(Name name) {
    return nameRepository.save(name);
  }

  public Optional<Name> findName(String name) {
    return nameRepository.findById(name);
  }

  public void deleteName(String name) {
    nameRepository.deleteById(name);
  }

  public Name updateName(Name name) {
    return saveName(name);
  }
  
  public List<Name> getAllNames() {
    return nameRepository.findAll();
  }

  public List<Name> getNamesByTag(String... tag) {
     return nameRepository.findByTagsIn(Arrays.stream(tag).collect(Collectors.toList()));
  }
}

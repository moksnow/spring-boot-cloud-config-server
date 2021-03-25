package com.mok.samples.repository;

import com.mok.samples.domain.Properties;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PropertiesRepository extends CrudRepository<Properties, Long> {

    List<Properties> findByApplication(String application);

    List<Properties> findByApplicationAndProfile(String application, String profile);

    List<Properties> findByApplicationAndProfileAndLabel(String application, String profile, String label);

    List<Properties> findByApplicationAndProfileAndLabelAndKey(String application, String profile,
                                                               String label, String key);

    Optional<Properties> findOneByApplicationAndProfileAndLabelAndKey(String application, String profile,
                                                                      String label, String key);

}

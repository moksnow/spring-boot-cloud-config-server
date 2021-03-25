package com.mok.samples.service;

import com.mok.samples.domain.Properties;
import com.mok.samples.repository.PropertiesRepository;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class PropertiesService {

    private final PropertiesRepository repository;

    public PropertiesService(PropertiesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/props")
    public Iterable<Properties> getAll() {
        return repository.findAll();
    }

    @GetMapping("/props/{application}")
    public Iterable<Properties> get(@PathVariable() String application) {
        return repository.findByApplication(application);
    }

    @GetMapping(value = "/props/{application}/{profile}")
    public Environment get(@PathVariable() String application, @PathVariable() String profile) {

        List<Properties> properties = repository.findByApplicationAndProfile(application, profile);

        Environment environment = new Environment
                ("Main configuration mok", new String[0], "Main configuration mok", "0.0.1", "active");

        Map<String, String> map = new HashMap<>();

        for (Properties property : properties) {
            map.put(property.getKey(), property.getValue());
        }
        environment.add(new PropertySource("Main map configuration", map));

        return environment;
    }

    @GetMapping("/props/{application}/{profile}/{label}")
    public Iterable<Properties> get(@PathVariable() String application, @PathVariable() String profile,
                                    @PathVariable() String label) {
        return repository.findByApplicationAndProfileAndLabel(application, profile, label);
    }

    @GetMapping("/props/{application}/{profile}/{label}/{key}")
    public Iterable<Properties> get(@PathVariable() String application, @PathVariable() String profile,
                                    @PathVariable() String label, @PathVariable() String key) {
        return repository.findByApplicationAndProfileAndLabelAndKey(application, profile, label, key);
    }

    @PutMapping("/props")
    public Optional<Properties> update(@RequestBody Properties insuranceProperties) {
        Optional<Properties> existing = repository.findOneByApplicationAndProfileAndLabelAndKey(
                insuranceProperties.getApplication(), insuranceProperties.getProfile(), insuranceProperties.getLabel(),
                insuranceProperties.getKey());
        return existing.map(rProp -> {
            rProp.setValue(insuranceProperties.getValue());
            return repository.save(rProp);
        });
    }

    @PostMapping("/props")
    public Properties create(@Valid @RequestBody Properties insuranceProperties) {
        return repository.save(insuranceProperties);
    }
}

package com.mok.samples.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTIES", schema = "PUBLIC")
@Data
public class Properties {
    private String application;
    private String profile;
    private String label;
    @Id
    private String key;
    private String value;
}

package com.github.oimdb.oimdbspike.domain;

import java.net.URL;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Meme {
    @GraphId 
    Long id;
    
    @NotNull
    @NotBlank
    @Indexed(unique=true) 
    String name;

    @NotNull
    @NotBlank
    URL url;
    
    MemeMedium medium;
    DateTime firstAppearance;
    
    public Meme() {
    }

    public Meme(String name, MemeMedium medium, URL url, DateTime firstAppeance) {
        this.name = name;
        this.medium = medium;
        this.url = url;
        this.firstAppearance = firstAppeance;
    }
    
    @Override
    public String toString() {
        return  name;
    }
}

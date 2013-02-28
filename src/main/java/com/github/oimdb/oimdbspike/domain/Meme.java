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
    private Long id;
    
    @NotNull
    @NotBlank
    @Indexed(unique=true) 
    private String name;

    @NotNull
    @NotBlank
    private URL url;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Meme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url=" + url +
                ", medium=" + medium +
                ", firstAppearance=" + firstAppearance +
                '}';
    }
}

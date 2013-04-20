package com.github.oimdb.oimdbspike.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.net.URL;
import java.util.Date;

@NodeEntity
public class Sighting {

    @GraphId
    private Long id;


    private String sightingText;

    private URL pictureUrl;

    public Date getIsoTimeOfSighting() {
        return isoTimeOfSighting;
    }

    public void setIsoTimeOfSighting(Date isoTimeOfSighting) {
        this.isoTimeOfSighting = isoTimeOfSighting;
    }

    public String getSightingText() {
        return sightingText;
    }

    public void setSightingText(String sightingText) {
        this.sightingText = sightingText;
    }

    public URL getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(URL pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    Date isoTimeOfSighting;

}

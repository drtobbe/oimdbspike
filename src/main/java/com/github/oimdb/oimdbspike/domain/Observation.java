package com.github.oimdb.oimdbspike.domain;

import java.net.URL;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Observation {
    @GraphId
    private Long id;
    
    @NotNull
    private double lattitude;

    @NotNull
    private double longitude;


    private double altitude;


    DateTime dateOfObservation;
    
    public Observation() {
    }

    public Observation(Double lang, Double lat, ObservationType medium, DateTime firstAppeance) {
        this.dateOfObservation = firstAppeance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Observation{" +
                "id=" + id +
                ", lattitude=" + lattitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", dateOfObservation=" + dateOfObservation +
                '}';
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public DateTime getDateOfObservation() {
        return dateOfObservation;
    }

    public void setDateOfObservation(DateTime dateOfObservation) {
        this.dateOfObservation = dateOfObservation;
    }
}

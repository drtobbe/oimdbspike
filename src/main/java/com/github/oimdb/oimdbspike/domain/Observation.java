package com.github.oimdb.oimdbspike.domain;

import java.net.URL;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.format.annotation.DateTimeFormat;
import sun.awt.EmbeddedFrame;

@NodeEntity
public class Observation {
    @GraphId
    private Long id;
    
    @NotNull
    private double lattitude;

    @NotNull
    private double longitude;


    private double altitude;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    Date dateOfObservation;
    
    public Observation() {
    }

    public Observation(Double lng, Double lat, ObservationType medium, Date dateOfObservation) {
        this.lattitude = lng;
        this.longitude = lat;
        this.dateOfObservation = dateOfObservation;
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

    public Date getDateOfObservation() {
        return dateOfObservation;
    }

    public void setDateOfObservation(Date dateOfObservation) {
        this.dateOfObservation = dateOfObservation;
    }
}

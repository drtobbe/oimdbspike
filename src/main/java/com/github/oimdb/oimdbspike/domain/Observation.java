package com.github.oimdb.oimdbspike.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.format.annotation.DateTimeFormat;

@NodeEntity
public class Observation {
    @GraphId
    private Long id;

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Sighting> getSightings() {
        return sightings;
    }

    public void setSightings(Set<Sighting> sightings) {
        this.sightings = sightings;
    }

    @NotNull
    private double lattitude;

    @NotNull
    private double longitude;

    @NotNull
    private double altitude;

    @NotNull
    private double direction;

    @NotNull
    private double viewAngle;



    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    Date dateOfObservation;

    @RelatedTo(type= "HAS_SIGHTINGS", direction = Direction.OUTGOING)
    java.util.Set<Sighting> sightings;

    public Observation() {
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getViewAngle() {
        return viewAngle;
    }

    public void setViewAngle(double viewAngle) {
        this.viewAngle = viewAngle;
    }

    public Observation(Double lng, Double lat, ObservationType medium, double altitude, double direction, double viewAngle , String name ) {
        this.lattitude = lng;
        this.longitude = lat;
        this.direction = direction;
        this.viewAngle = viewAngle;
        this.name = name;
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
                ", direction=" + direction +
                ", viewAngle=" + viewAngle +
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

    public void setAltitude(Long altitude) {
        this.altitude = altitude;
    }

    public Date getDateOfObservation() {
        return dateOfObservation;
    }

    public void setDateOfObservation(Date dateOfObservation) {
        this.dateOfObservation = dateOfObservation;
    }
}

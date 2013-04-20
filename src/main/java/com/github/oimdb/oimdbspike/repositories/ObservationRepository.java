package com.github.oimdb.oimdbspike.repositories;

import java.util.List;

import com.github.oimdb.oimdbspike.domain.Observation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface ObservationRepository extends GraphRepository<Observation> {
	
	@Query(" START n=node(*)" +
            " WHERE has(n.__type__) AND n.__type__ = 'com.github.oimdb.oimdbspike.domain.Observation'" +
            " RETURN n.id?")
	List<String> getAllObservationIds();


    @Query(" START n=node(*)" +
            " WHERE has(n.__type__) AND n.__type__ = 'com.github.oimdb.oimdbspike.domain.Observation'" +
            " RETURN n")
	List<Observation> getAllObservations();


}

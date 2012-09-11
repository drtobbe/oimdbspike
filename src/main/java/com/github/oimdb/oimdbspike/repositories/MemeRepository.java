package com.github.oimdb.oimdbspike.repositories;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import com.github.oimdb.oimdbspike.domain.Meme;

public interface MemeRepository extends GraphRepository<Meme> {
	
	@Query("START n=node(*)"+  
			"RETURN n.name?")
	List<String> getAllMemeNames();
}

package com.github.oimdb.oimdbspike.domain;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity
public class InspiredBy {
	@GraphId Long id;
	@StartNode
    Observation source;
	@EndNode
    Observation inspiration;
}

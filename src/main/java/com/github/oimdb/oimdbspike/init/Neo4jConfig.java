package com.github.oimdb.oimdbspike.init;

import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.github.oimdb.oimdbspike")
@EnableNeo4jRepositories("com.github.oimdb.oimdbspike.repositories")
@EnableTransactionManagement(mode=AdviceMode.PROXY)
public class Neo4jConfig extends Neo4jConfiguration {
	@Bean(name="graphDatabaseService")
	  public SpringRestGraphDatabase graphDatabaseService(){
		  SpringRestGraphDatabase sgdb = new SpringRestGraphDatabase("http://localhost:7474/db/data");
		  return sgdb;
	  }
}

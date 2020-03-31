package com.test.neo.demo.repository;

import com.test.neo.demo.domain.Node;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends Neo4jRepository<Node, Long> {

    Node findByName(String name);    
}
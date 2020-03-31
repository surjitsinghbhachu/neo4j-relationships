package com.test.neo.demo.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = RelatedNode.TYPE)
public class RelatedNode {

    public static final String TYPE = "RELATED_TO";

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Node start;

    @EndNode
    private Node end;

    // TODO: This is the attibute that causes the relationship duplication
    private long count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }
  
    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }    

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }  
}
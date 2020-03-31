package com.test.neo.demo.domain;

import java.util.HashSet;
import java.util.Set;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Node {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = RelatedNode.TYPE, direction = Relationship.UNDIRECTED)
    private Set<RelatedNode> relatedNodes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RelatedNode> getRelatedNodes() {
        return relatedNodes;
    }

    public void setRelatedNodes(Set<RelatedNode> relatedNodes) {
        this.relatedNodes = relatedNodes;
    }

    public void addRelatedNode(RelatedNode relatedNode) {
        this.relatedNodes.add(relatedNode);
    }

    /*

    CODE TO PREVENT DUPLICATE RELATIONSHIS

    public RelatedNode addRelatedNode(Node relatedNode, long count) {
        final RelatedNode node = this.relatedNodes.stream()
        .filter(i -> (relatedNode.getId().equals(i.getEnd().getId())) || (relatedNode.getId().equals(i.getStart().getId())))
			.findFirst()
			.orElseGet(() -> {
				RelatedNode newRelatedNode = new RelatedNode();
				newRelatedNode.setStart(this);
				newRelatedNode.setEnd(relatedNode);
				newRelatedNode.setCount(count);
				this.relatedNodes.add(newRelatedNode);
				return newRelatedNode;
            });
		return node;
    }
    
    public RelatedNode updateRelatedNode(Node relatedNode, long count) {
		final RelatedNode node = this.relatedNodes.stream()
        .filter(i -> (relatedNode.getId().equals(i.getEnd().getId())) || (relatedNode.getId().equals(i.getStart().getId())))
            .findFirst().get();
		if (node != null) {
			node.setCount(count);
		}
        return node;
	}

    public void deleteRelatedNode(Node relatedNode) {
		final RelatedNode node = this.relatedNodes.stream()
            .filter(i -> (relatedNode.getId().equals(i.getEnd().getId())) || (relatedNode.getId().equals(i.getStart().getId())))
            .findFirst().get();
        this.relatedNodes.remove(node);
    }
    */
}
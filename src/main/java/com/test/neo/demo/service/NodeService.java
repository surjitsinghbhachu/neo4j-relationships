package com.test.neo.demo.service;

import com.test.neo.demo.domain.Node;
import com.test.neo.demo.domain.RelatedNode;
import com.test.neo.demo.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    public Node findByName(String name) {
        return nodeRepository.findByName(name);
    }

    public void save(Node node) {
        nodeRepository.save(node);
    }

    @Transactional
    public void transactional() {

        // Test creating nodes C, D and two relationships between these same nodes in one transaction
        // this duplicates the relationships when the count attribute is added
        // if you remove the count attibute the relationship is not duplicated

        Node n1 = new Node();
        n1.setName("C");
        save(n1);

        Node n2 = new Node();
        n2.setName("D");
        save(n2);

        // create and save a relationship
        RelatedNode r1 = new RelatedNode();
        r1.setStart(n1);
        r1.setEnd(n2);
        r1.setCount(5);
        n1.addRelatedNode(r1);
        save(n1);     

        // create and save relationship again between same nodes
        RelatedNode r2 = new RelatedNode();
        r2.setStart(n1);
        r2.setEnd(n2);
        r2.setCount(5);
        n1.addRelatedNode(r2);
        save(n1);    
    }
}
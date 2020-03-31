package com.test.neo.demo.controller;

import com.test.neo.demo.domain.Node;
import com.test.neo.demo.domain.RelatedNode;
import com.test.neo.demo.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private NodeService nodeService;

    @RequestMapping(value = "/create", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String test1() {

        Node n1 = new Node();
        n1.setName("A");
        nodeService.save(n1);

        Node n2 = new Node();
        n2.setName("B");
        nodeService.save(n2);     

        return "Nodes created";
    } 

    @RequestMapping(value = "/relate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String relate() {

        Node n1 = nodeService.findByName("A");
        Node n2 = nodeService.findByName("B");
       
        RelatedNode r1 = new RelatedNode();
        r1.setStart(n1);
        r1.setEnd(n2);
        r1.setCount(5);

        n1.addRelatedNode(r1);
        nodeService.save(n1);      

        return "Nodes related";
    } 

    @RequestMapping(value = "/transactional", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String transactional() {
        nodeService.transactional();
        return "Nodes created and related within transaction";
    }

}
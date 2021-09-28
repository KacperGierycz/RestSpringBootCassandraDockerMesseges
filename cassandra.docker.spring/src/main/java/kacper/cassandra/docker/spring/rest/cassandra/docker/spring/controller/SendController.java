package kacper.cassandra.docker.spring.rest.cassandra.docker.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kacper.cassandra.docker.spring.rest.cassandra.docker.spring.model.Content;
import kacper.cassandra.docker.spring.rest.cassandra.docker.spring.repo.ContentRepository;

@RestController
@RequestMapping("/api")
public class SendController {

	@Autowired
	ContentRepository contentRepository;
	
	
	  @PostMapping("/send")
	  public ResponseEntity<List<Content>>
	  sendMessages() {
	  List<Content> send = new ArrayList<Content>();
	  
	  // messageRepo.findByMagic_numberContaining(magic_number).forEach(send::add);
	  try {
		  
		    List<Content> message = new ArrayList<Content>();
		    List<Content> messageDeleted = new ArrayList<Content>();
		    message=contentRepository.findAll();

		    if (message.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    
		    for(Content mes:message) {
		    	if (mes.getMagic_number()==101) {
		    		contentRepository.delete(mes);
		    		messageDeleted.add(mes);
		    	}
		    }

		    return new ResponseEntity<>(messageDeleted, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  	
	  }
	
	
	
	
	
}

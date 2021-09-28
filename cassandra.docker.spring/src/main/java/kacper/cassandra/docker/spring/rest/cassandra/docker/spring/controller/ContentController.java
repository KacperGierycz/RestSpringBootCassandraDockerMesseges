package kacper.cassandra.docker.spring.rest.cassandra.docker.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kacper.cassandra.docker.spring.rest.cassandra.docker.spring.model.Content;
import kacper.cassandra.docker.spring.rest.cassandra.docker.spring.repo.ContentRepository;

@RestController
@RequestMapping("/api")
public class ContentController {

	@Autowired
	ContentRepository contentRepository;

	@PostMapping("/message")
	public Content addMessage(@RequestBody Content message) {
		message.setCompoKey1();
		contentRepository.save(message);
		return message;
	}

	@GetMapping("/messages")
	public List<Content> getMessages() {
		return contentRepository.findAll();

	}
	
//	@DeleteMapping("/messages/{id}")
//	public ResponseEntity<Content> deleteMessage(@PathVariable(value="id")int id) {
//	//	Optional<Message> del = messageRepo.findById(id);
//		Optional<Content> message=contentRepository.findById(id);
//		
//		  if (message.isPresent()) {
//			  contentRepository.deleteById(id);
//			    return new ResponseEntity(message.get(), HttpStatus.OK);
//			  } else {
//			    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			  }
//	}
	
	  @GetMapping("/messages/{email}") 
	public ResponseEntity<List<Content>>
	  getMessagesByEmail(@PathVariable(value="email")String email){
	  
		  try {
		  
		    List<Content> message = new ArrayList<Content>();
		    List<Content> messageDeleted = new ArrayList<Content>();
		    message=contentRepository.findAll();

		    if (message.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		    
		    for(Content mes:message) {
		    	if (mes.getEmail().equals(email)) {
		    		contentRepository.delete(mes);
		    		messageDeleted.add(mes);
		    	}
		    }

		    return new ResponseEntity<>(messageDeleted, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	  
	  
	
	  
	  }
	 		
//		  @PostMapping("/send")
//		  public ResponseEntity<List<Content>>
//		  sendMessages() {
//		  List<Content> send = new ArrayList<Content>();
//		  
//		  // messageRepo.findByMagic_numberContaining(magic_number).forEach(send::add);
//		  try {
//			  
//			    List<Content> message = new ArrayList<Content>();
//			    List<Content> messageDeleted = new ArrayList<Content>();
//			    message=contentRepository.findAll();
//
//			    if (message.isEmpty()) {
//			      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			    }
//			    
//			    for(Content mes:message) {
//			    	if (mes.getMagic_number()==101) {
//			    		contentRepository.delete(mes);
//			    		messageDeleted.add(mes);
//			    	}
//			    }
//
//			    return new ResponseEntity<>(messageDeleted, HttpStatus.OK);
//			  } catch (Exception e) {
//			    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//			  }
//		  	
//		  }
		  
		  
		  
		  
		  
}

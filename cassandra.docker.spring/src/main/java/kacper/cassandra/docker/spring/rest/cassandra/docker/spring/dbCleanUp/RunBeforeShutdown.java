package kacper.cassandra.docker.spring.rest.cassandra.docker.spring.dbCleanUp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PreDestroy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import kacper.cassandra.docker.spring.rest.cassandra.docker.spring.model.Content;
import kacper.cassandra.docker.spring.rest.cassandra.docker.spring.repo.ContentRepository;

@Component
public class RunBeforeShutdown {
	
	@Autowired
	ContentRepository contentRepository;
	
//	private static final Logger log = LoggerFactory.getLogger(RunAfterStartup.class);
	
    @PreDestroy
    public void destroy() {
    	
    	 
    	System.out.println("database ...maintnance ");
    //	log.info("database ...maintnance "); 
    	List<Content> send = new ArrayList<Content>();

    	send= contentRepository.findAll();
    	
    	if(send.isEmpty()) {
    	
   // 	log.info("database clear"); 
    		System.out.println("database clear");
    	
    	Content jan = new Content("jan.kowalski@example.com", "Interview","simple text", 101, new Date());
    	Content anna = new Content("anna.zajkowska@example.com","Interview 3","simple text 3",22,new Date());
//    	Content jan2 = new Content("jan.kowalski@example.com","Interview 3","simple text 3",22,new Date());
    	

    	

    	contentRepository.save(jan);
    	contentRepository.save(anna);

    	}
  //  	log.info("It was funny. Cheers!!");
    	
    	System.out.println("It was funny. Cheers!!");
    }

}

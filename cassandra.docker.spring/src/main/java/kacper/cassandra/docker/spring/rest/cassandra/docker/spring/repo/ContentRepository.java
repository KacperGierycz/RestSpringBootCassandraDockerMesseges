package kacper.cassandra.docker.spring.rest.cassandra.docker.spring.repo;




import java.util.Date;
import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import kacper.cassandra.docker.spring.rest.cassandra.docker.spring.model.Content;




public interface ContentRepository extends CassandraRepository<Content, Date> {
	
//	@Query(select * from Content )
//	List<Content>findByMagic_numberContaining(String magic_number);
	
//	@Query("select * from Content where email = iemail")
//	List<Content>findByEmail(String iemail);

}

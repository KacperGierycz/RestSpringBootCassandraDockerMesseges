package kacper.cassandra.docker.spring.rest.cassandra.docker.spring.model;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class Content {

	private String email;

	private String title;
	private String content;
	private int magic_number;
	private Date date=new Date();
	
	@PrimaryKey
	private String compoKey1;
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMagic_number() {
		return magic_number;
	}

	public void setMagic_number(int magic_number) {
		this.magic_number = magic_number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCompoKey1() {
		return compoKey1;
	}

	public void setCompoKey1() {
		this.compoKey1=date+email+title;
	}

	public Content(String email, String title, String content, int magic_number, Date date) {
		super();
		this.email = email;
		this.title = title;
		this.content = content;
		this.magic_number = magic_number;
		this.date = date;
		this.compoKey1=date+email+title;
	}

	public Content() {
		
	}
	
	
	
	
//    @Builder
//	public
//    Content(String email,String title,String content,int magic_number,Date date){
//    	
//    	this.email=email;
//    	this.title=title;
//    	this.content=content;
//    	this.magic_number=magic_number;
//    	this.date=date;
//    	this.compoKey1=new CompoKey(title,email,date).toString();
//    }



}

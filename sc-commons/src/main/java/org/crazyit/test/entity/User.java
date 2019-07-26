package org.crazyit.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SC_USER")
public class User {
	
	public static final String TYPE_CUSTOMER = "CUSTOMER";
	
	public static final String TYPE_MANAGER = "MANAGER";

    @Id
    @GeneratedValue
	private Integer id;
    
    private String name;
    
    private String password;
    
    private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
}

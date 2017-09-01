package com.learning.data.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DummyUser
{
	@Id
	private Long userId; //Basic Value Type
	private String firstName; //Basic Value Type
	private String lastName; //Basic Value Type
	private User referredBy; //Entity Type
	private List<String> aliases; // Collection Value Type
	private Address address; // Composite Value Type
	
}


package com.sakila.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Country {
	public short ID ; 
	public String Name ; 
	public Timestamp UpdateDate;
	 
	 public Country () { 
		this.ID = 0;
		this.Name = "";
		this.UpdateDate = Timestamp.valueOf(LocalDateTime.now());
	 } 
	 public Country(short id, String sname, Timestamp updt ) { 
		 this.ID = id; 
		 this.Name = sname; 
		 this.UpdateDate = updt; 
	 } 
}

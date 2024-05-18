package com.sakila.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Actor {
	public short ID ;
	public String FirstName;
	public String LastName;
	public Timestamp UpdateDate;
	
	public Actor () { 
		this.ID = 0;
		this.FirstName = "";
		this.LastName = "";
        this.UpdateDate = Timestamp.valueOf(LocalDateTime.now());
	 } 
	 public Actor (Short aid, String fname, String lame, Timestamp UpDate) { 
		 this.ID = aid;
		 this.FirstName = fname;
		 this.LastName = lame;
		 this.UpdateDate = UpDate;
	 } 
}


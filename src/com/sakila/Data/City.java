package com.sakila.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class City {
	public short ID ; 
	public String Name ;
	public short CountryID;
	public Timestamp UpdateDate;
	 
	 public City () { 
		this.ID = 0;
		this.Name = "";
		this.CountryID = 0;
		this.UpdateDate = Timestamp.valueOf(LocalDateTime.now());
	 } 
	 public City(Short id, String sname, short ctryid, Timestamp updt) { 
		 this.ID = id;
		 this.Name = sname;
		 this.CountryID = ctryid;
		 this.UpdateDate = updt;
	 } 
}

package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BloodCount {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int colid;
	private int apos; 
	private int aneg; 
	private int bpos; 
	private int bneg; 
	private int abpos;
	private int abneg; 
	private int opos; 
	private int oneg;
	public int getColid() {
		return colid;
	}
	public void setColid(int colid) {
		this.colid = colid;
	}
	public int getApos() {
		return apos;
	}
	public void setApos(int apos) {
		this.apos = apos;
	}
	public int getAneg() {
		return aneg;
	}
	public void setAneg(int aneg) {
		this.aneg = aneg;
	}
	public int getBpos() {
		return bpos;
	}
	public void setBpos(int bpos) {
		this.bpos = bpos;
	}
	public int getBneg() {
		return bneg;
	}
	public void setBneg(int bneg) {
		this.bneg = bneg;
	}
	public int getAbpos() {
		return abpos;
	}
	public void setAbpos(int abpos) {
		this.abpos = abpos;
	}
	public int getAbneg() {
		return abneg;
	}
	public void setAbneg(int abneg) {
		this.abneg = abneg;
	}
	public int getOpos() {
		return opos;
	}
	public void setOpos(int opos) {
		this.opos = opos;
	}
	public int getOneg() {
		return oneg;
	}
	public void setOneg(int oneg) {
		this.oneg = oneg;
	}
	@Override
	public String toString() {
		return "BloodCount [colid=" + colid + ", apos=" + apos + ", aneg=" + aneg + ", bpos=" + bpos + ", bneg=" + bneg
				+ ", abpos=" + abpos + ", abneg=" + abneg + ", opos=" + opos + ", oneg=" + oneg + "]";
	}
	public String findMapper(String bloodgroup) {
		if(bloodgroup.equalsIgnoreCase("a+"))
		{
			return "apos";
		}
		if(bloodgroup.equalsIgnoreCase("b+"))
		{
			return "bpos";
		}
		if(bloodgroup.equalsIgnoreCase("ab+"))
		{
			return "abpos";
		}
		if(bloodgroup.equalsIgnoreCase("o+"))
		{
			return "opos";
		}
		if(bloodgroup.equalsIgnoreCase("a-"))
		{
			return "aneg";
		}
		if(bloodgroup.equalsIgnoreCase("b-"))
		{
			return "bneg";
		}
		if(bloodgroup.equalsIgnoreCase("ab-"))
		{
			return "abneg";
		}
		return "oneg";
	}
	public int valueMapper(String mapper) 
	{
		if(mapper.equalsIgnoreCase("apos"))
		{
			return this.apos;
		}
		if(mapper.equalsIgnoreCase("bpos"))
		{
			return this.bpos;
		}
		if(mapper.equalsIgnoreCase("abpos"))
		{
			return this.abpos;
		}
		if(mapper.equalsIgnoreCase("opos"))
		{
			return this.opos;
		}
		if(mapper.equalsIgnoreCase("aneg"))
		{
			return this.aneg;
		}
		if(mapper.equalsIgnoreCase("bneg"))
		{
			return this.bneg;
		}
		if(mapper.equalsIgnoreCase("abneg"))
		{
			return this.abneg;
		}
		return this.oneg;
	}
	
    
	
	
	
	
}

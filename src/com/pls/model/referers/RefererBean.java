package com.pls.model.referers;

import javax.persistence.*;

@Entity
@Table(name = "REFERERS")
public class RefererBean 
{
	@Id @GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(nullable = false)
	private String refererName;
	
	@Column //Nullable
	private String refererDesignation;
	
	@Column (nullable=false)
	private int refererCutRate;
	
	@Column //Nullable
	private String notes;

	/**************************************************************************/
	//Getters and Setters
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getRefererName()
	{
		return refererName;
	}

	public void setRefererName(String refererName)
	{
		this.refererName = refererName;
	}

	public String getRefererDesignation()
	{
		return refererDesignation;
	}

	public void setRefererDesignation(String refererDesignation)
	{
		this.refererDesignation = refererDesignation;
	}

	public int getRefererCutRate()
	{
		return refererCutRate;
	}

	public void setRefererCutRate(int refererCutRate)
	{
		this.refererCutRate = refererCutRate;
	}

	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

}
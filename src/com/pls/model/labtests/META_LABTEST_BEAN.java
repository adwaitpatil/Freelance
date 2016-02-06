package com.pls.model.labtests;

import java.util.List;
import java.util.ArrayList;


import javax.persistence.*;

@Entity
@Table(name = "LABTEST_META_MASTER")
public class META_LABTEST_BEAN
{
	//@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id")
	//private int id;
	
	//Name of the test must be unique for retrieval purposes
	@Id @Column(name = "name")
	private String name;
	
	//Number of fields in the test
	@Column(nullable = false, name="rows")
	private int rows;
	
	//The list of field names
	@ElementCollection
	@CollectionTable(name="FIELD_TITLES_LIST", joinColumns=@JoinColumn(name="id"))
	private List<String> field_titles_list = new ArrayList<String>();
	
	//The list of field min
	@ElementCollection
	@CollectionTable(name="FIELD_MIN_LIST", joinColumns=@JoinColumn(name="id"))
	private List<String> field_min_list = new ArrayList<String>();
	
	//The list of field max
	@ElementCollection
	@CollectionTable(name="FIELD_MAX_LIST", joinColumns=@JoinColumn(name="id"))
	private List<String> field_max_list = new ArrayList<String>();
	
	//The list of field unit
	@ElementCollection
	@CollectionTable(name="FIELD_UNIT_LIST", joinColumns=@JoinColumn(name="id"))
	private List<String> field_unit_list = new ArrayList<String>();

	
	
	//Getters and Setters
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getRows()
	{
		return rows;
	}

	public void setRows(int rows)
	{
		this.rows = rows;
	}

	public List<String> getField_titles_list()
	{
		return field_titles_list;
	}

	public void setField_titles_list(List<String> field_titles_list)
	{
		this.field_titles_list = field_titles_list;
	}

	public List<String> getField_min_list()
	{
		return field_min_list;
	}

	public void setField_min_list(List<String> field_min_list)
	{
		this.field_min_list = field_min_list;
	}

	public List<String> getField_max_list()
	{
		return field_max_list;
	}

	public void setField_max_list(List<String> field_max_list)
	{
		this.field_max_list = field_max_list;
	}

	public List<String> getField_unit_list()
	{
		return field_unit_list;
	}

	public void setField_unit_list(List<String> field_unit_list)
	{
		this.field_unit_list = field_unit_list;
	}
	
	
}
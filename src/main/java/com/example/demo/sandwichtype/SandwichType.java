package com.example.demo.sandwichtype;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "s_type")
public class SandwichType {
	@Id
	private Integer id;
	@NotBlank
	private String typeName;

	public SandwichType(Integer id, @NotBlank String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}

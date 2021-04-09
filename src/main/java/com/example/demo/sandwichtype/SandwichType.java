package com.example.demo.sandwichtype;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "s_type")
public class SandwichType {
	// @OneToMany(cascade = CascadeType.ALL, targetEntity = Sandwich.class)
	// @JoinColumn(name = "sTypeId")
	@Id
	private int id;
	@NotBlank
	private String typeName;

	public SandwichType() {
	}

	public SandwichType(int id, @NotBlank String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}

	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((typeName == null) ? 0 : typeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SandwichType other = (SandwichType) obj;
		if (id != other.id)
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		return true;
	}

}

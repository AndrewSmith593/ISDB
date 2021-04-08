package com.example.demo.sandwich;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "sandwich")
public class Sandwich {

	@Id
	@SequenceGenerator(name = "sandwich_sequence", sequenceName = "sandwich_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sandwich_sequence")
	private Integer id;

	@NotBlank
	@Size(min = 5, max = 50, message = "Sandwich name must be between 5 and 50 characters long.")
	private String name;

	@NotBlank
	private String ingredients;

	@NotNull
	private Integer creatorId;

	@NotNull
	private boolean shared;

	@NotNull
	private int sTypeId;

	public Sandwich(String name, String ingredients, Integer creatorId,
			boolean shared, int sTypeId) {
		super();
		this.name = name;
		this.ingredients = ingredients;
		this.creatorId = creatorId;
		this.shared = shared;
		this.sTypeId = sTypeId;
	}

	public Sandwich(Integer id, String name, String ingredients,
			Integer creatorId, boolean shared, int sTypeId) {
		super();
		this.id = id;
		this.name = name;
		this.ingredients = ingredients;
		this.creatorId = creatorId;
		this.shared = shared;
		this.sTypeId = sTypeId;
	}

	public Sandwich() {
		super();
	}

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

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public Integer getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Integer creatorId) {
		this.creatorId = creatorId;
	}

	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public int getsTypeId() {
		return sTypeId;
	}

	public void setsTypeId(int sTypeId) {
		this.sTypeId = sTypeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((creatorId == null) ? 0 : creatorId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((ingredients == null) ? 0 : ingredients.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + sTypeId;
		result = prime * result + (shared ? 1231 : 1237);
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
		Sandwich other = (Sandwich) obj;
		if (creatorId == null) {
			if (other.creatorId != null)
				return false;
		} else if (!creatorId.equals(other.creatorId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sTypeId != other.sTypeId)
			return false;
		if (shared != other.shared)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sandwich [id=" + id + ", name=" + name + ", ingredients="
				+ ingredients + ", creatorId=" + creatorId + ", shared="
				+ shared + ", sTypeId=" + sTypeId + "]";
	}

}

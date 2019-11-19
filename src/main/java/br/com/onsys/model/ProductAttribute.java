package br.com.onsys.model;


import io.swagger.annotations.*;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ProductAttribute  implements Serializable {


	private static final long serialVersionUID = 1L;
	private String name;
	private String value;


	/**
	 * Nome do atributo
	 **/
	@ApiModelProperty(required = true, value = "Nome do atributo")
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Valor do atributo
	 **/
	@ApiModelProperty(required = true, value = "Valor do atributo")
	@JsonProperty("value")
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		ProductAttribute other = (ProductAttribute) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	@Override
	public String toString()  {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProductAttribute {\n");

		sb.append("  name: ").append(name).append("\n");
		sb.append("  value: ").append(value).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}

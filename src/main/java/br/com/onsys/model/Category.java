package br.com.onsys.model;


import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Category  {
  
  private Integer id = null;
  private String name = null;
  private Integer parentId = null;
  private Integer items = null;
  private List<CategoryAttribute> attributes = new ArrayList<CategoryAttribute>() ;
  private List<Category> categories = new ArrayList<Category>() ;

  
  /**
   * ID da categoria
   **/
  @ApiModelProperty(required = true, value = "ID da categoria")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   * Nome da categoria
   **/
  @ApiModelProperty(required = true, value = "Nome da categoria")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * ID da categoria pai
   **/
  @ApiModelProperty(required = true, value = "ID da categoria pai")
  @JsonProperty("parentId")
  public Integer getParentId() {
    return parentId;
  }
  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  
  /**
   * Quantidade de produtos existentes nessa categoria
   **/
  @ApiModelProperty(required = true, value = "Quantidade de produtos existentes nessa categoria")
  @JsonProperty("items")
  public Integer getItems() {
    return items;
  }
  public void setItems(Integer items) {
    this.items = items;
  }

  
  /**
   * Características do produto para a categoria
   **/
  @ApiModelProperty(value = "Características do produto para a categoria")
  @JsonProperty("attributes")
  public List<CategoryAttribute> getAttributes() {
    return attributes;
  }
  public void setAttributes(List<CategoryAttribute> attributes) {
    this.attributes = attributes;
  }

  
  /**
   * Lista de sub-categorias (filhas)
   **/
  @ApiModelProperty(required = true, value = "Lista de sub-categorias (filhas)")
  @JsonProperty("categories")
  public List<Category> getCategories() {
    return categories;
  }
  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  parentId: ").append(parentId).append("\n");
    sb.append("  items: ").append(items).append("\n");
    sb.append("  attributes: ").append(attributes).append("\n");
    sb.append("  categories: ").append(categories).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

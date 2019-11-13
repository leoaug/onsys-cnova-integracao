package br.com.onsys.model;


import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class CategoryAttribute  {
  
  private String name = null;
  private List<String> values = new ArrayList<String>() ;
  private Boolean isVariant = null;

  
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
   * Lista de domínios para atributos variantes
   **/
  @ApiModelProperty(required = true, value = "Lista de dom�nios para atributos variantes")
  @JsonProperty("values")
  public List<String> getValues() {
    return values;
  }
  public void setValues(List<String> values) {
    this.values = values;
  }

  
  /**
   * Identifica se atributo pode sofrer variações
   **/
  @ApiModelProperty(required = true, value = "Identifica se atributo pode sofrer variações")
  @JsonProperty("isVariant")
  public Boolean getIsVariant() {
    return isVariant;
  }
  public void setIsVariant(Boolean isVariant) {
    this.isVariant = isVariant;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryAttribute {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  values: ").append(values).append("\n");
    sb.append("  isVariant: ").append(isVariant).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

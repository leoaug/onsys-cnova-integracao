package br.com.onsys.model;


import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Warehouse  {
  
  private Integer id = null;
  private List<String> sites = new ArrayList<String>() ;

  
  /**
   * ID do warehouse. Ele deve ser utilizado nas atualizações de estoque dos produtos.
   **/
  @ApiModelProperty(required = true, value = "ID do warehouse. Ele deve ser utilizado nas atualizações de estoque dos produtos.")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   * Lista de sites que esse warehouse atende.
   **/
  @ApiModelProperty(required = true, value = "Lista de sites que esse warehouse atende.")
  @JsonProperty("sites")
  public List<String> getSites() {
    return sites;
  }
  public void setSites(List<String> sites) {
    this.sites = sites;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Warehouse {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  sites: ").append(sites).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

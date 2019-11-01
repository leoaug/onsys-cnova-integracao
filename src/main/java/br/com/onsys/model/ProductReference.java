package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ProductReference  {
  
  private String id = null;
  private String href = null;

  
  /**
   * ID do recurso
   **/
  @ApiModelProperty(required = true, value = "ID do recurso")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Link para acesso ao recurso
   **/
  @ApiModelProperty(required = true, value = "Link para acesso ao recurso")
  @JsonProperty("href")
  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductReference {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  href: ").append(href).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

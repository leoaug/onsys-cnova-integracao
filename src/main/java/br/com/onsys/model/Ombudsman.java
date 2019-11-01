package br.com.onsys.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Ombudsman  {
  
  private Boolean active = null;
  private String source = null;
  private Date createdAt = null;

  
  /**
   * Quando for 'true' se o protocolo estiver na Ouvidoria, e 'false' se não estiver
   **/
  @ApiModelProperty(value = "Quando for 'true' se o protocolo estiver na Ouvidoria, e 'false' se não estiver")
  @JsonProperty("active")
  public Boolean getActive() {
    return active;
  }
  public void setActive(Boolean active) {
    this.active = active;
  }

  
  /**
   * Quando um protocolo está como ouvidoria com valor 'true' os possíveis valores são: Facebook / Procon / Reclameaqui / Twitter / Outros.
   **/
  @ApiModelProperty(value = "Quando um protocolo está como ouvidoria com valor 'true' os possíveis valores são: Facebook / Procon / Reclameaqui / Twitter / Outros.")
  @JsonProperty("source")
  public String getSource() {
    return source;
  }
  public void setSource(String source) {
    this.source = source;
  }

  
  /**
   * Data de entrada na Ouvidoria
   **/
  @ApiModelProperty(value = "Data de entrada na Ouvidoria")
  @JsonProperty("createdAt")
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Ombudsman {\n");
    
    sb.append("  active: ").append(active).append("\n");
    sb.append("  source: ").append(source).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

package br.com.onsys.model;


import java.util.Date;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class TicketSla  {
  
  private Date expireAt = null;
  private Boolean delayed = null;

  
  /**
   * Data de expiração para resolução do ticket.
   **/
  @ApiModelProperty(value = "Data de expiração para resolução do ticket.")
  @JsonProperty("expireAt")
  public Date getExpireAt() {
    return expireAt;
  }
  public void setExpireAt(Date expireAt) {
    this.expireAt = expireAt;
  }

  
  /**
   * Indicador de atraso do ticket.
   **/
  @ApiModelProperty(value = "Indicador de atraso do ticket.")
  @JsonProperty("delayed")
  public Boolean getDelayed() {
    return delayed;
  }
  public void setDelayed(Boolean delayed) {
    this.delayed = delayed;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TicketSla {\n");
    
    sb.append("  expireAt: ").append(expireAt).append("\n");
    sb.append("  delayed: ").append(delayed).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

package br.com.onsys.model;


import java.util.Date;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class TicketMessage  {
  
  private Date createdAt = null;
  private String id = null;
  private UserReference user = null;
  private String body = null;
  private String visibility = null;

  
  /**
   * Data de criação do Ticket
   **/
  @ApiModelProperty(required = true, value = "Data de criação do Ticket")
  @JsonProperty("createdAt")
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  
  /**
   * Id do Ticket
   **/
  @ApiModelProperty(required = true, value = "Id do Ticket")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Usuário
   **/
  @ApiModelProperty(required = true, value = "Usuário")
  @JsonProperty("user")
  public UserReference getUser() {
    return user;
  }
  public void setUser(UserReference user) {
    this.user = user;
  }

  
  /**
   * Texto da mensagem
   **/
  @ApiModelProperty(required = true, value = "Texto da mensagem")
  @JsonProperty("body")
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }

  
  /**
   * Se o consumidor final irá receber/visualizar a mensagem. Os valores permitidos são: 'private' e 'public'
   **/
  @ApiModelProperty(required = true, value = "Se o consumidor final irá receber/visualizar a mensagem. Os valores permitidos são: 'private' e 'public'")
  @JsonProperty("visibility")
  public String getVisibility() {
    return visibility;
  }
  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TicketMessage {\n");
    
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  user: ").append(user).append("\n");
    sb.append("  body: ").append(body).append("\n");
    sb.append("  visibility: ").append(visibility).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

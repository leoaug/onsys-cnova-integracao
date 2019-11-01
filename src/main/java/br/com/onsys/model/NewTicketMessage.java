package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class NewTicketMessage  {
  
  private UserReference user = null;
  private String visibility = null;
  private String body = null;

  
  /**
   * Informações de usuário
   **/
  @ApiModelProperty(required = true, value = "Informações de usuário")
  @JsonProperty("user")
  public UserReference getUser() {
    return user;
  }
  public void setUser(UserReference user) {
    this.user = user;
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

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewTicketMessage {\n");
    
    sb.append("  user: ").append(user).append("\n");
    sb.append("  visibility: ").append(visibility).append("\n");
    sb.append("  body: ").append(body).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

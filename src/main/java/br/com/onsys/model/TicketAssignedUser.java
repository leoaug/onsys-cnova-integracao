package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class TicketAssignedUser  {
  
  private String user = null;
  private String group = null;

  
  /**
   * Identificador do assunto.
   **/
  @ApiModelProperty(value = "Identificador do assunto.")
  @JsonProperty("user")
  public String getUser() {
    return user;
  }
  public void setUser(String user) {
    this.user = user;
  }

  
  /**
   * Descrição do assunto relacionado ao ticket.
   **/
  @ApiModelProperty(value = "Descrição do assunto relacionado ao ticket.")
  @JsonProperty("group")
  public String getGroup() {
    return group;
  }
  public void setGroup(String group) {
    this.group = group;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class TicketAssignedUser {\n");
    
    sb.append("  user: ").append(user).append("\n");
    sb.append("  group: ").append(group).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

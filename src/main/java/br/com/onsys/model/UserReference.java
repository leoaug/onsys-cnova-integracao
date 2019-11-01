package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class UserReference  {
  
  private String login = null;
  private String name = null;

  
  /**
   * Login do usuário que fará o atendimento do Ticket
   **/
  @ApiModelProperty(required = true, value = "Login do usuário que fará o atendimento do Ticket")
  @JsonProperty("login")
  public String getLogin() {
    return login;
  }
  public void setLogin(String login) {
    this.login = login;
  }

  
  /**
   * Nome do usuário que fará o atendimento do Ticket
   **/
  @ApiModelProperty(required = true, value = "Nome do usuário que fará o atendimento do Ticket")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserReference {\n");
    
    sb.append("  login: ").append(login).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

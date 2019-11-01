package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class CustomerReference  {
  
  private String name = null;
  private String phoneNumber = null;

  
  /**
   * Nome do cliente
   **/
  @ApiModelProperty(value = "Nome do cliente")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Telefone do cliente
   **/
  @ApiModelProperty(value = "Telefone do cliente")
  @JsonProperty("phoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerReference {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  phoneNumber: ").append(phoneNumber).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

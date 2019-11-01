package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Phone  {
  
  private String number = null;
  public enum TypeEnum {
     HOME,  MOBILE,  OFFICE, 
  };
  private TypeEnum type = null;

  
  /**
   * Número do telefone
   **/
  @ApiModelProperty(required = true, value = "Número do telefone")
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }
  public void setNumber(String number) {
    this.number = number;
  }

  
  /**
   * Tipo do telefone
   **/
  @ApiModelProperty(required = true, value = "Tipo do telefone")
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Phone {\n");
    
    sb.append("  number: ").append(number).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Carrier  {
  
  private String name = null;
  private String cnpj = null;

  
  /**
   * Nome da transportadora
   **/
  @ApiModelProperty(value = "Nome da transportadora")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * CNPJ da transportadora
   **/
  @ApiModelProperty(value = "CNPJ da transportadora")
  @JsonProperty("cnpj")
  public String getCnpj() {
    return cnpj;
  }
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Carrier {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  cnpj: ").append(cnpj).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

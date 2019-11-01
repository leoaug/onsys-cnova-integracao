package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class PhonesSandbox  {
  
  private String mobile = null;
  private String home = null;
  private String office = null;

  
  /**
   * Telefone celular do cliente
   **/
  @ApiModelProperty(required = true, value = "Telefone celular do cliente")
  @JsonProperty("mobile")
  public String getMobile() {
    return mobile;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  
  /**
   * Telefone residencial do cliente
   **/
  @ApiModelProperty(required = true, value = "Telefone residencial do cliente")
  @JsonProperty("home")
  public String getHome() {
    return home;
  }
  public void setHome(String home) {
    this.home = home;
  }

  
  /**
   * Telefone de trabalho do cliente
   **/
  @ApiModelProperty(required = true, value = "Telefone de trabalho do cliente")
  @JsonProperty("office")
  public String getOffice() {
    return office;
  }
  public void setOffice(String office) {
    this.office = office;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhonesSandbox {\n");
    
    sb.append("  mobile: ").append(mobile).append("\n");
    sb.append("  home: ").append(home).append("\n");
    sb.append("  office: ").append(office).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

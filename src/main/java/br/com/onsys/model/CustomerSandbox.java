package br.com.onsys.model;


import java.util.Date;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class CustomerSandbox  {
  
  private String name = null;
  private String gender = null;
  private String documentNumber = null;
  public enum TypeEnum {
     PF,  PJ, 
  };
  private TypeEnum type = null;
  private String email = null;
  private Date bornAt = null;
  private BillingAddress billing = null;
  private PhonesSandbox phones = null;

  
  /**
   * Nome do cliente
   **/
  @ApiModelProperty(required = true, value = "Nome do cliente")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Sexo - Masculino ou Feminino
   **/
  @ApiModelProperty(required = true, value = "Sexo - Masculino ou Feminino")
  @JsonProperty("gender")
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }

  
  /**
   * Número de documento do cliente
   **/
  @ApiModelProperty(required = true, value = "Número de documento do cliente")
  @JsonProperty("documentNumber")
  public String getDocumentNumber() {
    return documentNumber;
  }
  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  
  /**
   * Tipo de cliente (Pessoa Física / Jurídica)
   **/
  @ApiModelProperty(required = true, value = "Tipo de cliente (Pessoa Física / Jurídica)")
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }

  
  /**
   * Email do cliente
   **/
  @ApiModelProperty(required = true, value = "Email do cliente")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  
  /**
   * Data de nascimento
   **/
  @ApiModelProperty(required = true, value = "Data de nascimento")
  @JsonProperty("bornAt")
  public Date getBornAt() {
    return bornAt;
  }
  public void setBornAt(Date bornAt) {
    this.bornAt = bornAt;
  }

  
  /**
   * Endereço do cliente
   **/
  @ApiModelProperty(required = true, value = "Endereço do cliente")
  @JsonProperty("billing")
  public BillingAddress getBilling() {
    return billing;
  }
  public void setBilling(BillingAddress billing) {
    this.billing = billing;
  }

  
  /**
   * Telefones do cliente
   **/
  @ApiModelProperty(required = true, value = "Telefones do cliente")
  @JsonProperty("phones")
  public PhonesSandbox getPhones() {
    return phones;
  }
  public void setPhones(PhonesSandbox phones) {
    this.phones = phones;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerSandbox {\n");
    
    sb.append("  name: ").append(name).append("\n");
    sb.append("  gender: ").append(gender).append("\n");
    sb.append("  documentNumber: ").append(documentNumber).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  bornAt: ").append(bornAt).append("\n");
    sb.append("  billing: ").append(billing).append("\n");
    sb.append("  phones: ").append(phones).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

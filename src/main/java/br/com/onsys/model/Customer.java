package br.com.onsys.model;


import java.util.Date;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Customer  {
  
  private String id = null;
  private String name = null;
  private String documentNumber = null;
  public enum TypeEnum {
     PF,  PJ, 
  };
  private TypeEnum type = null;
  private Date createdAt = null;
  private String email = null;
  private Date birthDate = null;
  private List<Phone> phones = new ArrayList<Phone>() ;

  
  /**
   * Identificador do cliente
   **/
  @ApiModelProperty(required = true, value = "Identificador do cliente")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Nome completo do cliente
   **/
  @ApiModelProperty(required = true, value = "Nome completo do cliente")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Documento do cliente
   **/
  @ApiModelProperty(required = true, value = "Documento do cliente")
  @JsonProperty("documentNumber")
  public String getDocumentNumber() {
    return documentNumber;
  }
  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  
  /**
   * Tipo de cliente: Pessoa Física ou Jurídica
   **/
  @ApiModelProperty(required = true, value = "Tipo de cliente: Pessoa Física ou Jurídica")
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }

  
  /**
   * Data de envio do produto
   **/
  @ApiModelProperty(value = "Data de envio do produto")
  @JsonProperty("createdAt")
  public Date getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
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
   * Data de nascimento do cliente
   **/
  @ApiModelProperty(value = "Data de nascimento do cliente")
  @JsonProperty("birthDate")
  public Date getBirthDate() {
    return birthDate;
  }
  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  
  /**
   * Lista de telefones do cliente
   **/
  @ApiModelProperty(required = true, value = "Lista de telefones do cliente")
  @JsonProperty("phones")
  public List<Phone> getPhones() {
    return phones;
  }
  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  documentNumber: ").append(documentNumber).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  createdAt: ").append(createdAt).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  birthDate: ").append(birthDate).append("\n");
    sb.append("  phones: ").append(phones).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

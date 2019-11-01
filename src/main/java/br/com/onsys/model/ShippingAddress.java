package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ShippingAddress  {
  
  private String address = null;
  private String number = null;
  private String complement = null;
  private String quarter = null;
  private String reference = null;
  private String city = null;
  private String state = null;
  private String countryId = null;
  private String zipCode = null;
  private String recipientName = null;

  
  /**
   * Endereço (nome da rua, avenida ... )
   **/
  @ApiModelProperty(required = true, value = "Endereço (nome da rua, avenida ... )")
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  
  /**
   * Número do endereço
   **/
  @ApiModelProperty(required = true, value = "Número do endereço")
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }
  public void setNumber(String number) {
    this.number = number;
  }

  
  /**
   * Informações adicionais
   **/
  @ApiModelProperty(required = true, value = "Informações adicionais")
  @JsonProperty("complement")
  public String getComplement() {
    return complement;
  }
  public void setComplement(String complement) {
    this.complement = complement;
  }

  
  /**
   * Bairro
   **/
  @ApiModelProperty(required = true, value = "Bairro")
  @JsonProperty("quarter")
  public String getQuarter() {
    return quarter;
  }
  public void setQuarter(String quarter) {
    this.quarter = quarter;
  }

  
  /**
   * Pontos de referência
   **/
  @ApiModelProperty(value = "Pontos de referência")
  @JsonProperty("reference")
  public String getReference() {
    return reference;
  }
  public void setReference(String reference) {
    this.reference = reference;
  }

  
  /**
   * Cidade
   **/
  @ApiModelProperty(required = true, value = "Cidade")
  @JsonProperty("city")
  public String getCity() {
    return city;
  }
  public void setCity(String city) {
    this.city = city;
  }

  
  /**
   * Estado
   **/
  @ApiModelProperty(required = true, value = "Estado")
  @JsonProperty("state")
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }

  
  /**
   * Identificação do País. Baseado na ISO-3166, padrão alpha 2. Ex.: BR, US, AR
   **/
  @ApiModelProperty(required = true, value = "Identificação do País. Baseado na ISO-3166, padrão alpha 2. Ex.: BR, US, AR")
  @JsonProperty("countryId")
  public String getCountryId() {
    return countryId;
  }
  public void setCountryId(String countryId) {
    this.countryId = countryId;
  }

  
  /**
   * Código de Endereçamento Postal - CEP
   **/
  @ApiModelProperty(required = true, value = "Código de Endereçamento Postal - CEP")
  @JsonProperty("zipCode")
  public String getZipCode() {
    return zipCode;
  }
  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  
  /**
   * Nome do destinatario
   **/
  @ApiModelProperty(value = "Nome do destinatario")
  @JsonProperty("recipientName")
  public String getRecipientName() {
    return recipientName;
  }
  public void setRecipientName(String recipientName) {
    this.recipientName = recipientName;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShippingAddress {\n");
    
    sb.append("  address: ").append(address).append("\n");
    sb.append("  number: ").append(number).append("\n");
    sb.append("  complement: ").append(complement).append("\n");
    sb.append("  quarter: ").append(quarter).append("\n");
    sb.append("  reference: ").append(reference).append("\n");
    sb.append("  city: ").append(city).append("\n");
    sb.append("  state: ").append(state).append("\n");
    sb.append("  countryId: ").append(countryId).append("\n");
    sb.append("  zipCode: ").append(zipCode).append("\n");
    sb.append("  recipientName: ").append(recipientName).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

package br.com.onsys.model;


import java.util.Date;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Invoice  {
  
  private String cnpj = null;
  private String number = null;
  private String serie = null;
  private Date issuedAt = null;
  private String accessKey = null;
  private String linkXml = null;
  private String linkDanfe = null;

  
  /**
   * CNPJ responsável pelo envio dos produtos. Pode ser diferente caso a empresa possua diversos Centros de Distribuição (CDs)
   **/
  @ApiModelProperty(value = "CNPJ responsável pelo envio dos produtos. Pode ser diferente caso a empresa possua diversos Centros de Distribuição (CDs)")
  @JsonProperty("cnpj")
  public String getCnpj() {
    return cnpj;
  }
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  
  /**
   * Número da Nota Fiscal
   **/
  @ApiModelProperty(value = "Número da Nota Fiscal")
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }
  public void setNumber(String number) {
    this.number = number;
  }

  
  /**
   * Número de serie da Nota Fiscal
   **/
  @ApiModelProperty(value = "Número de serie da Nota Fiscal")
  @JsonProperty("serie")
  public String getSerie() {
    return serie;
  }
  public void setSerie(String serie) {
    this.serie = serie;
  }

  
  /**
   * Data de emissão da Nota Fiscal
   **/
  @ApiModelProperty(value = "Data de emissão da Nota Fiscal")
  @JsonProperty("issuedAt")
  public Date getIssuedAt() {
    return issuedAt;
  }
  public void setIssuedAt(Date issuedAt) {
    this.issuedAt = issuedAt;
  }

  
  /**
   * Número da chave de acesso à nota fiscal. A chave possui 44 dígitos e contém todas as informações da DANFE
   **/
  @ApiModelProperty(value = "Número da chave de acesso à nota fiscal. A chave possui 44 dígitos e contém todas as informações da DANFE")
  @JsonProperty("accessKey")
  public String getAccessKey() {
    return accessKey;
  }
  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  
  /**
   * Url para consulta da NFE
   **/
  @ApiModelProperty(value = "Url para consulta da NFE")
  @JsonProperty("linkXml")
  public String getLinkXml() {
    return linkXml;
  }
  public void setLinkXml(String linkXml) {
    this.linkXml = linkXml;
  }

  
  /**
   * Url para consulta da DANFE
   **/
  @ApiModelProperty(value = "Url para consulta da DANFE")
  @JsonProperty("linkDanfe")
  public String getLinkDanfe() {
    return linkDanfe;
  }
  public void setLinkDanfe(String linkDanfe) {
    this.linkDanfe = linkDanfe;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Invoice {\n");
    
    sb.append("  cnpj: ").append(cnpj).append("\n");
    sb.append("  number: ").append(number).append("\n");
    sb.append("  serie: ").append(serie).append("\n");
    sb.append("  issuedAt: ").append(issuedAt).append("\n");
    sb.append("  accessKey: ").append(accessKey).append("\n");
    sb.append("  linkXml: ").append(linkXml).append("\n");
    sb.append("  linkDanfe: ").append(linkDanfe).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

package br.com.onsys.model;


import java.util.Date;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class StockUpdatingStatus  {
  
  private Integer warehouse = null;
  private String skuSellerId = null;
  private String status = null;
  private Date processedAt = null;
  private Double updateValue = null;
  private String refer = null;
  private String skuSite = null;
  private List<String> siteList = new ArrayList<String>() ;
  private List<Error> errors = new ArrayList<Error>() ;

  
  /**
   * Localização fisica do estoque
   **/
  @ApiModelProperty(value = "Localização fisica do estoque")
  @JsonProperty("warehouse")
  public Integer getWarehouse() {
    return warehouse;
  }
  public void setWarehouse(Integer warehouse) {
    this.warehouse = warehouse;
  }

  
  /**
   * SKU do produto do lojista que deverá ser alterado
   **/
  @ApiModelProperty(value = "SKU do produto do lojista que deverá ser alterado")
  @JsonProperty("skuSellerId")
  public String getSkuSellerId() {
    return skuSellerId;
  }
  public void setSkuSellerId(String skuSellerId) {
    this.skuSellerId = skuSellerId;
  }

  
  /**
   * Status da solicitação de atualização
   **/
  @ApiModelProperty(value = "Status da solicitação de atualização")
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  
  /**
   * Data do processamento
   **/
  @ApiModelProperty(value = "Data do processamento")
  @JsonProperty("processedAt")
  public Date getProcessedAt() {
    return processedAt;
  }
  public void setProcessedAt(Date processedAt) {
    this.processedAt = processedAt;
  }

  
  /**
   * Valor de atualização
   **/
  @ApiModelProperty(value = "Valor de atualização")
  @JsonProperty("updateValue")
  public Double getUpdateValue() {
    return updateValue;
  }
  public void setUpdateValue(Double updateValue) {
    this.updateValue = updateValue;
  }

  
  /**
   * Arquivo de referência da atualização
   **/
  @ApiModelProperty(value = "Arquivo de referência da atualização")
  @JsonProperty("refer")
  public String getRefer() {
    return refer;
  }
  public void setRefer(String refer) {
    this.refer = refer;
  }

  
  /**
   * SKU do site onde o estoque será atualizado
   **/
  @ApiModelProperty(value = "SKU do site onde o estoque será atualizado")
  @JsonProperty("skuSite")
  public String getSkuSite() {
    return skuSite;
  }
  public void setSkuSite(String skuSite) {
    this.skuSite = skuSite;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("siteList")
  public List<String> getSiteList() {
    return siteList;
  }
  public void setSiteList(List<String> siteList) {
    this.siteList = siteList;
  }

  
  /**
   * Erros do pedido
   **/
  @ApiModelProperty(value = "Erros do pedido")
  @JsonProperty("errors")
  public List<Error> getErrors() {
    return errors;
  }
  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class StockUpdatingStatus {\n");
    
    sb.append("  warehouse: ").append(warehouse).append("\n");
    sb.append("  skuSellerId: ").append(skuSellerId).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  processedAt: ").append(processedAt).append("\n");
    sb.append("  updateValue: ").append(updateValue).append("\n");
    sb.append("  refer: ").append(refer).append("\n");
    sb.append("  skuSite: ").append(skuSite).append("\n");
    sb.append("  siteList: ").append(siteList).append("\n");
    sb.append("  errors: ").append(errors).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

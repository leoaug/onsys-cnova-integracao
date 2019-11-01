package br.com.onsys.model;


import java.util.Date;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class PricesUpdatingStatus  {
  
  private String skuSellerId = null;
  private String status = null;
  private Date processedAt = null;
  private Double updateValue = null;
  private String siteName = null;
  private List<Error> errors = new ArrayList<Error>() ;

  
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
   * Status do pedido
   **/
  @ApiModelProperty(value = "Status do pedido")
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
   * Nome do site
   **/
  @ApiModelProperty(value = "Nome do site")
  @JsonProperty("siteName")
  public String getSiteName() {
    return siteName;
  }
  public void setSiteName(String siteName) {
    this.siteName = siteName;
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
    sb.append("class PricesUpdatingStatus {\n");
    
    sb.append("  skuSellerId: ").append(skuSellerId).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  processedAt: ").append(processedAt).append("\n");
    sb.append("  updateValue: ").append(updateValue).append("\n");
    sb.append("  siteName: ").append(siteName).append("\n");
    sb.append("  errors: ").append(errors).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

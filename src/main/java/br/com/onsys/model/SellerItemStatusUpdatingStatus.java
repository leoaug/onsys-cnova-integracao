package br.com.onsys.model;


import java.util.Date;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SellerItemStatusUpdatingStatus  {
  
  private String skuSellerId = null;
  private String site = null;
  private String status = null;
  private Date processedAt = null;
  private String updateValue = null;
  private String siteName = null;
  private String skuSite = null;
  private List<Error> errors = new ArrayList<Error>() ;

  
  /**
   * SKU do produto do lojista que deverá ser alterado
   **/
  @ApiModelProperty(required = true, value = "SKU do produto do lojista que deverá ser alterado")
  @JsonProperty("skuSellerId")
  public String getSkuSellerId() {
    return skuSellerId;
  }
  public void setSkuSellerId(String skuSellerId) {
    this.skuSellerId = skuSellerId;
  }

  
  /**
   * Site de venda
   **/
  @ApiModelProperty(value = "Site de venda")
  @JsonProperty("site")
  public String getSite() {
    return site;
  }
  public void setSite(String site) {
    this.site = site;
  }

  
  /**
   * Status do produto
   **/
  @ApiModelProperty(required = true, value = "Status do produto")
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
   * Atualização
   **/
  @ApiModelProperty(value = "Atualização")
  @JsonProperty("updateValue")
  public String getUpdateValue() {
    return updateValue;
  }
  public void setUpdateValue(String updateValue) {
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
   * Sku do site
   **/
  @ApiModelProperty(value = "Sku do site")
  @JsonProperty("skuSite")
  public String getSkuSite() {
    return skuSite;
  }
  public void setSkuSite(String skuSite) {
    this.skuSite = skuSite;
  }

  
  /**
   * Lista de erros que ocorreram produto
   **/
  @ApiModelProperty(value = "Lista de erros que ocorreram produto")
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
    sb.append("class SellerItemStatusUpdatingStatus {\n");
    
    sb.append("  skuSellerId: ").append(skuSellerId).append("\n");
    sb.append("  site: ").append(site).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  processedAt: ").append(processedAt).append("\n");
    sb.append("  updateValue: ").append(updateValue).append("\n");
    sb.append("  siteName: ").append(siteName).append("\n");
    sb.append("  skuSite: ").append(skuSite).append("\n");
    sb.append("  errors: ").append(errors).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

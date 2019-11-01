package br.com.onsys.model;


import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SellerItemStatusUpdate  {
  
  private String skuSellerId = null;
  private List<SellerItemStatus> status = new ArrayList<SellerItemStatus>() ;

  
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
   * Status do produto
   **/
  @ApiModelProperty(required = true, value = "Status do produto")
  @JsonProperty("status")
  public List<SellerItemStatus> getStatus() {
    return status;
  }
  public void setStatus(List<SellerItemStatus> status) {
    this.status = status;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SellerItemStatusUpdate {\n");
    
    sb.append("  skuSellerId: ").append(skuSellerId).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

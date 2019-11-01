package br.com.onsys.model;


import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class SellerItemStocks  {
  
  private String skuSellerId = null;
  private List<Stock> stocks = new ArrayList<Stock>() ;

  
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
   * Estoque do produto
   **/
  @ApiModelProperty(required = true, value = "Estoque do produto")
  @JsonProperty("stocks")
  public List<Stock> getStocks() {
    return stocks;
  }
  public void setStocks(List<Stock> stocks) {
    this.stocks = stocks;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class SellerItemStocks {\n");
    
    sb.append("  skuSellerId: ").append(skuSellerId).append("\n");
    sb.append("  stocks: ").append(stocks).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

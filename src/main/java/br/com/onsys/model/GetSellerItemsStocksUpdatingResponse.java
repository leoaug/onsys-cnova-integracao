package br.com.onsys.model;



import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetSellerItemsStocksUpdatingResponse  {
  
  private List<StockUpdatingStatus> skus = new ArrayList<StockUpdatingStatus>() ;
  private List<MetadataEntry> metadata = new ArrayList<MetadataEntry>() ;

  
  /**
   * Lista de produtos e seus respectivos processos de atualização de estoque
   **/
  @ApiModelProperty(value = "Lista de produtos e seus respectivos processos de atualização de estoque")
  @JsonProperty("skus")
  public List<StockUpdatingStatus> getSkus() {
    return skus;
  }
  public void setSkus(List<StockUpdatingStatus> skus) {
    this.skus = skus;
  }

  
  /**
   * Dados adicionais da consulta
   **/
  @ApiModelProperty(value = "Dados adicionais da consulta")
  @JsonProperty("metadata")
  public List<MetadataEntry> getMetadata() {
    return metadata;
  }
  public void setMetadata(List<MetadataEntry> metadata) {
    this.metadata = metadata;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSellerItemsStocksUpdatingResponse {\n");
    
    sb.append("  skus: ").append(skus).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

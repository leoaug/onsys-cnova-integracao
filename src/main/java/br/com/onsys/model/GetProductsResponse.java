package br.com.onsys.model;


import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetProductsResponse  {
  
  private List<ProductResponseItem> skus = new ArrayList<ProductResponseItem>() ;
  private List<MetadataEntry> metadata = new ArrayList<MetadataEntry>() ;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("skus")
  public List<ProductResponseItem> getSkus() {
    return skus;
  }
  public void setSkus(List<ProductResponseItem> skus) {
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
    sb.append("class GetProductsResponse {\n");
    
    sb.append("  skus: ").append(skus).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

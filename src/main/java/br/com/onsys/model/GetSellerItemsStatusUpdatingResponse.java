package br.com.onsys.model;



import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetSellerItemsStatusUpdatingResponse  {
  
  private List<SellerItemStatusUpdatingStatus> skus = new ArrayList<SellerItemStatusUpdatingStatus>() ;
  private List<MetadataEntry> metadata = new ArrayList<MetadataEntry>() ;

  
  /**
   * Informações de status de SKU do produto do lojista
   **/
  @ApiModelProperty(value = "Informações de status de SKU do produto do lojista")
  @JsonProperty("skus")
  public List<SellerItemStatusUpdatingStatus> getSkus() {
    return skus;
  }
  public void setSkus(List<SellerItemStatusUpdatingStatus> skus) {
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
    sb.append("class GetSellerItemsStatusUpdatingResponse {\n");
    
    sb.append("  skus: ").append(skus).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

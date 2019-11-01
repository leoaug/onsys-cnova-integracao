package br.com.onsys.model;



import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetOrdersTrackingUpdatingResponse  {
  
  private List<OrderTrackingUpdatingStatus> trackings = new ArrayList<OrderTrackingUpdatingStatus>() ;
  private List<MetadataEntry> metadata = new ArrayList<MetadataEntry>() ;

  
  /**
   * Informações de tracking do pedido
   **/
  @ApiModelProperty(value = "Informações de tracking do pedido")
  @JsonProperty("trackings")
  public List<OrderTrackingUpdatingStatus> getTrackings() {
    return trackings;
  }
  public void setTrackings(List<OrderTrackingUpdatingStatus> trackings) {
    this.trackings = trackings;
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
    sb.append("class GetOrdersTrackingUpdatingResponse {\n");
    
    sb.append("  trackings: ").append(trackings).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

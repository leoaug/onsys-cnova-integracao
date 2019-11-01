package br.com.onsys.model;


import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetOrdersStatusNewResponse  {
  
  private List<OrderStatusNew> orders = new ArrayList<OrderStatusNew>() ;
  private List<MetadataEntry> metadata = new ArrayList<MetadataEntry>() ;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("orders")
  public List<OrderStatusNew> getOrders() {
    return orders;
  }
  public void setOrders(List<OrderStatusNew> orders) {
    this.orders = orders;
  }

  
  /**
   * Leia mais sobre os metadados retornados nas listagens em <a href='../apis/index.html#search' target='_blank'>Metadada</a>
   **/
  @ApiModelProperty(required = true, value = "Leia mais sobre os metadados retornados nas listagens em <a href='../apis/index.html#search' target='_blank'>Metadada</a>")
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
    sb.append("class GetOrdersStatusNewResponse {\n");
    
    sb.append("  orders: ").append(orders).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

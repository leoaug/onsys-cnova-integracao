package br.com.onsys.model;



import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetWarehousesResponse  {
  
  private List<Warehouse> warehouses = new ArrayList<Warehouse>() ;
  private List<MetadataEntry> metadata = new ArrayList<MetadataEntry>() ;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("warehouses")
  public List<Warehouse> getWarehouses() {
    return warehouses;
  }
  public void setWarehouses(List<Warehouse> warehouses) {
    this.warehouses = warehouses;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
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
    sb.append("class GetWarehousesResponse {\n");
    
    sb.append("  warehouses: ").append(warehouses).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

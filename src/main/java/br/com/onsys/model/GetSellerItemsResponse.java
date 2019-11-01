package br.com.onsys.model;



import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetSellerItemsResponse  {
  
  private List<SellerItem> sellerItems = new ArrayList<SellerItem>() ;
  private List<MetadataEntry> metadata = new ArrayList<MetadataEntry>() ;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("sellerItems")
  public List<SellerItem> getSellerItems() {
    return sellerItems;
  }
  public void setSellerItems(List<SellerItem> sellerItems) {
    this.sellerItems = sellerItems;
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
    sb.append("class GetSellerItemsResponse {\n");
    
    sb.append("  sellerItems: ").append(sellerItems).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

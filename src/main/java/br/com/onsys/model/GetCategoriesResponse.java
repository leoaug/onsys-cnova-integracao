package br.com.onsys.model;



import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetCategoriesResponse  {
  
  private List<Category> categories = new ArrayList<Category>() ;
  private List<MetadataEntry> metadata = new ArrayList<MetadataEntry>() ;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("categories")
  public List<Category> getCategories() {
    return categories;
  }
  public void setCategories(List<Category> categories) {
    this.categories = categories;
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
    sb.append("class GetCategoriesResponse {\n");
    
    sb.append("  categories: ").append(categories).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

package br.com.onsys.model;


import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GetSitesResponse  {
  
  private Integer totalRows = null;
  private List<Site> sites = new ArrayList<Site>() ;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("totalRows")
  public Integer getTotalRows() {
    return totalRows;
  }
  public void setTotalRows(Integer totalRows) {
    this.totalRows = totalRows;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("sites")
  public List<Site> getSites() {
    return sites;
  }
  public void setSites(List<Site> sites) {
    this.sites = sites;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetSitesResponse {\n");
    
    sb.append("  totalRows: ").append(totalRows).append("\n");
    sb.append("  sites: ").append(sites).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

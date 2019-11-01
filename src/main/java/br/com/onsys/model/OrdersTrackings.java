package br.com.onsys.model;

import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class OrdersTrackings  {
  
  private List<OrderTracking> trackings = new ArrayList<OrderTracking>() ;

  
  /**
   * Lista de trackings
   **/
  @ApiModelProperty(value = "Lista de trackings")
  @JsonProperty("trackings")
  public List<OrderTracking> getTrackings() {
    return trackings;
  }
  public void setTrackings(List<OrderTracking> trackings) {
    this.trackings = trackings;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrdersTrackings {\n");
    
    sb.append("  trackings: ").append(trackings).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

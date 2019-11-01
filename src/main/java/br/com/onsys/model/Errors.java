package br.com.onsys.model;


import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Errors  {
  
  private List<Error> errors = new ArrayList<Error>() ;

  
  /**
   * Lista contendo os skus que não puderam ser cancelado e o erro para cada um
   **/
  @ApiModelProperty(value = "Lista contendo os skus que não puderam ser cancelado e o erro para cada um")
  @JsonProperty("errors")
  public List<Error> getErrors() {
    return errors;
  }
  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Errors {\n");
    
    sb.append("  errors: ").append(errors).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

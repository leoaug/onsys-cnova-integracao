package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Image  {
  
  private String type = null;
  private Boolean main = null;
  private String url = null;

  
  /**
   * Formato da imagem
   **/
  @ApiModelProperty(required = true, value = "Formato da imagem")
  @JsonProperty("type")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  
  /**
   * Flag que indica se a imagem é a principal
   **/
  @ApiModelProperty(required = true, value = "Flag que indica se a imagem é a principal")
  @JsonProperty("main")
  public Boolean getMain() {
    return main;
  }
  public void setMain(Boolean main) {
    this.main = main;
  }

  
  /**
   * URL da imagem do produto
   **/
  @ApiModelProperty(required = true, value = "URL da imagem do produto")
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Image {\n");
    
    sb.append("  type: ").append(type).append("\n");
    sb.append("  main: ").append(main).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

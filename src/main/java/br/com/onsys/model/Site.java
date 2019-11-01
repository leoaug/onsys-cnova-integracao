package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Site  {
  
  private Integer id = null;
  private String name = null;
  private String mnemonic = null;
  private String url = null;

  
  /**
   * ID do site
   **/
  @ApiModelProperty(required = true, value = "ID do site")
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  
  /**
   * Nome do site
   **/
  @ApiModelProperty(required = true, value = "Nome do site")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Código que deverá ser utilizado nas operações que exigem o site. Exemplo: <code>GET /sellerItems?_offset=0&_limit=10&site=EX</code> para trazer produtos vendidos apenas no Extra
   **/
  @ApiModelProperty(required = true, value = "Código que deverá ser utilizado nas operações que exigem o site. Exemplo: <code>GET /sellerItems?_offset=0&_limit=10&site=EX</code> para trazer produtos vendidos apenas no Extra")
  @JsonProperty("mnemonic")
  public String getMnemonic() {
    return mnemonic;
  }
  public void setMnemonic(String mnemonic) {
    this.mnemonic = mnemonic;
  }

  
  /**
   * URL base para consultar produtos nesse site
   **/
  @ApiModelProperty(required = true, value = "URL base para consultar produtos nesse site")
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
    sb.append("class Site {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  mnemonic: ").append(mnemonic).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

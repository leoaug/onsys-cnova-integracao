package br.com.onsys.api.client.auth;


import java.util.Map;

public class OAuth implements Authentication {
  @Override
  public void applyToParams(Map<String, String> queryParams, Map<String, String> headerParams) {
    // TODO: support oauth
  }
}

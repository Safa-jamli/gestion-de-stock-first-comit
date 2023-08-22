package com.jamli.gestiondestoks.config;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.github.scribejava.apis.FlickrApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
@Configuration
public class FlickrConfiguration {
    @Value("${flickr.apiKey}")
    private String apiKey;
    @Value("${flickr.apiSecret}")
    private String apiSecret;
    @Value("${flickr.appKey}")
    private String appKey;

    @Value("${flickr.appSecret}")
    private String appSecret;

   /* @Bean
    public Flickr getFlickr() throws InterruptedException, ExecutionException, IOException, FlickrException {
  Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
   //creation d'un objet avec la permission de mon application
   OAuth10aService service = new ServiceBuilder(apiKey)
           .apiSecret(apiSecret)
           .build(FlickrApi.instance(FlickrApi.FlickrPerm.DELETE));
   //sacnner pour gerer mon apptoken appsecret
    final Scanner scanner = new Scanner(System.in);
   //recuperer le request token
    final OAuth1RequestToken request = service.getRequestToken();
    //authorisation de  url pour utiliser l'api
    final String authUrl = service.getAuthorizationUrl(request);

    System.out.println(authUrl);System.out.println("Paste it here >> ");

    final String authVerifier = scanner.nextLine();
   //generer le access token pour notre api
    OAuth1AccessToken accessToken = service.getAccessToken(request, authVerifier);
    System.out.println(accessToken.getToken());
    System.out.println(accessToken.getTokenSecret());

    Auth auth = flickr.getAuthInterface().checkToken(accessToken);

    System.out.println("---------------------------");
    System.out.println(auth.getToken());
   System.out.println(auth.getTokenSecret());
    return flickr;
  }*/
    @Bean
   public Flickr getFlickr(){
        Flickr flickr = new Flickr(apiKey, apiSecret, new REST());
        Auth auth = new Auth();
        auth.setPermission(Permission.READ);
        auth.setToken(appKey);
        auth.setTokenSecret(appSecret);
        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);
        return flickr;
    }

}

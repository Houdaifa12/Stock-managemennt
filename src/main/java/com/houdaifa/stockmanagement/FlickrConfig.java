package com.houdaifa.stockmanagement;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.auth.Auth;
import com.github.scribejava.apis.FlickrApi;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1AccessToken;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.github.scribejava.core.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

@Configuration
public class FlickrConfig {
    @Value("${flickr.apiKey}")
    private String ApiKey;
    @Value("${flickr.apiSecret}")
    private String ApiSecret;

    public Flickr getFlicker() throws IOException, ExecutionException, InterruptedException, FlickrException {
       Flickr flickr=new Flickr(ApiKey,ApiSecret,new REST());

   OAuth10aService service=new ServiceBuilder(ApiKey)
           .apiSecret(ApiSecret)
           .build(FlickrApi.instance(FlickrApi.FlickrPerm.WRITE));
   final Scanner scanner=new Scanner(System.in);
   final OAuth1RequestToken requestToken=service.getRequestToken();
   final String authUrl=service.getAuthorizationUrl(requestToken);
   System.out.println("authUrl");
   System.out.println("Paste it here");
   final  String authVerifier=scanner.nextLine();
   OAuth1AccessToken accessToken=service.getAccessToken(requestToken,authVerifier);
   System.out.println(accessToken.getToken());
   System.out.println(accessToken.getTokenSecret());
   Auth auth=flickr.getAuthInterface().checkToken(accessToken);
   System.out.println(auth.getToken());
   System.out.println(auth.getTokenSecret());
   return flickr;
    }

}

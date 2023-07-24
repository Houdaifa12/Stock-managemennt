package com.houdaifa.stockmanagement.services.impl;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.houdaifa.stockmanagement.services.FlickrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.InputStream;
import java.util.Locale;

public class FlickrServicempl implements FlickrService {
    @Value("${flicker.apiKey}")
    private  String apiKey;
    @Value("${flicker.apiSecret}")
    private String apiSecret;

    @Value("${flickr.appKey}")
    private String appKey;

    @Value("${flickr.appSecret}")
    private String appSecret;
    @Autowired
    private Flickr flickr;

    @Override
    public String savePhoto(InputStream photo, String title) throws FlickrException {
        UploadMetaData uploadMetaData=new UploadMetaData();
        uploadMetaData.setTitle(title);
        String PhotoId=flickr.getUploader().upload(photo,uploadMetaData);
        return  flickr.getPhotosInterface().getPhoto(PhotoId).getMedium640Url();
    }




}

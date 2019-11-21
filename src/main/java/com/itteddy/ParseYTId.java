package com.itteddy;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Named("parseYTId")
public class ParseYTId {
    private final static Logger logger = LoggerFactory.getLogger(ParseYTId.class);

    public String parse(String url) throws URISyntaxException {

        List<NameValuePair> params= URLEncodedUtils.parse(new URI(url), Charset.forName("UTF-8"));
        for (NameValuePair param : params) {
            logger.info(param.getName() +" : "+ param.getValue()); 
            if (param.getName().equals("v"))
            {
                
                return param.getValue();
            }
          }
          return null;
    }
}

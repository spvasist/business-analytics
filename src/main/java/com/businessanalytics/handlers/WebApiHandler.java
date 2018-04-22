package com.businessanalytics.handlers;

import com.businessanalytics.content.ContentRequest;
import com.businessanalytics.controllers.WebApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by srikanth on 13-04-2017.
 */
@RestController("/analyze")
@Component
public class WebApiHandler {
    private final
    WebApiController webApiController;

    @Autowired
    public WebApiHandler(WebApiController webApiController) {
        this.webApiController = webApiController;
    }

    @RequestMapping(value = "/amazon-product", method = RequestMethod.POST)
    public void analyze(@RequestBody ContentRequest<String> contentRequest) {
        //contentRequest.setContentType(ContentTypes.TOI_NEWS);
        //contentRequest.setDataSource("D:\\news.txt");
        webApiController.performAnalysis(contentRequest);
    }
}

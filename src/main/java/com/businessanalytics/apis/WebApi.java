package com.businessanalytics.apis;

import com.businessanalytics.beans.content.ContentRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by srikanth on 13-04-2017.
 */
@RestController
@Component
public interface WebApi {
    @RequestMapping("/analyze")
    void analyze(@RequestBody(required = false) ContentRequest contentRequest);
}

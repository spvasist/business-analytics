package com.businessanalytics;

import com.businessanalytics.beans.content.ContentRequest;
import com.businessanalytics.contentengines.ContentTypes;
import com.businessanalytics.handlers.WebApiHandler;
import com.businessanalytics.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
public class BusinessAnalyticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessAnalyticsApplication.class, args);

    }
}

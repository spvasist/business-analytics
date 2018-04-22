package com.businessanalytics.content;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
@Data
public class ContentRequest<T> {
    ContentTypes contentType;
    T dataSource;
}

package com.businessanalytics.content.retrievers;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public interface ContentRetriever<T> {
    T fetchContent(String source);
}

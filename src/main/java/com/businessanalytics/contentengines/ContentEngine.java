package com.businessanalytics.contentengines;

import com.businessanalytics.beans.content.Content;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public interface ContentEngine {
    Content fetchContent(String url);
}

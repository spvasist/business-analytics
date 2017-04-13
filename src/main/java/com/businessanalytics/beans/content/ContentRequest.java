package com.businessanalytics.beans.content;

import com.businessanalytics.contentengines.ContentTypes;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
@Data
public class ContentRequest {
    ContentTypes contentType;
    Object requestData;
}

package com.businessanalytics.contentengines;

import com.businessanalytics.beans.content.ToiContent;
import com.businessanalytics.utils.FileUtil;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public class ToiContentEngine implements ContentEngine {

    @Override
    public ToiContent fetchContent(String url) {
        ToiContent toiContent = new ToiContent();
        toiContent.setBody(FileUtil.readFileString(url));
        return toiContent;
    }
}

package com.businessanalytics.content.retrievers;

import com.businessanalytics.content.beans.amazon.AmazonProductComment;
import com.businessanalytics.utils.FileUtil;

import java.util.Collections;
import java.util.List;

public class AmazonProductContentRetriever implements ContentRetriever {
    @Override
    public List<AmazonProductComment> fetchContent(String source) {
        AmazonProductComment amazonProductComment = new AmazonProductComment();
        amazonProductComment.setBody(FileUtil.readFileString(source));
        return Collections.singletonList(amazonProductComment);
    }
}

package com.businessanalytics.content.retrievers;

import com.businessanalytics.content.beans.amazon.AmazonProduct;
import org.springframework.stereotype.Component;

@Component
public class AmazonProductContentRetriever implements ContentRetriever<AmazonProduct> {
    @Override
    public AmazonProduct fetchContent(String source) {
        return new AmazonProduct();
    }
}

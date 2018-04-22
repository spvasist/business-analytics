package com.businessanalytics.content.retrievers;

import com.businessanalytics.content.beans.amazon.AmazonProduct;
import org.springframework.stereotype.Component;

@Component
public class AmazonProductContentRetriever implements ContentRetriever<AmazonProduct> {
    @Override
    public AmazonProduct fetchContent(String source) {
        AmazonProduct amazonProduct = new AmazonProduct();
        amazonProduct.setDescription(source);
        return amazonProduct;
    }
}

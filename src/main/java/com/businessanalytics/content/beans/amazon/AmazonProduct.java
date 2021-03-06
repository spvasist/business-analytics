package com.businessanalytics.content.beans.amazon;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AmazonProduct {
    public String id;
    public String name;
    public List<String> images;
    public String description;
    public Map<String, String> details;
    public String price;
    public List<AmazonProductComment> amazonProductComments;
}

package com.businessanalytics.analysis.engines.result.beans;

import lombok.Data;

import java.util.List;

@Data
public class AmazonProductAnalysisResult {
    public int totalComments;
    public int positiveComments;
    public int negativeComments;
    public int informativeComments;
    public int usefulComments;
    public List<AmazonProductCommentAnalysisResult> amazonProductCommentAnalysisResults;
}

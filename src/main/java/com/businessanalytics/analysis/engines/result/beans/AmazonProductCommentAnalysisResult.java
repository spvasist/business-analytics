package com.businessanalytics.analysis.engines.result.beans;

import com.businessanalytics.content.beans.amazon.AmazonProductComment;
import lombok.Data;

@Data
public class AmazonProductCommentAnalysisResult {
    public AmazonProductComment amazonProductComment;
    public boolean useful;
    public boolean positive;
    public boolean informative;
    public double weight;
}

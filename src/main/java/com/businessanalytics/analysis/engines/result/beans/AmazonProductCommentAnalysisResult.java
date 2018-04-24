package com.businessanalytics.analysis.engines.result.beans;

import com.businessanalytics.content.beans.amazon.AmazonProductComment;
import com.businessanalytics.content.beans.base.UserCommentMood;
import lombok.Data;

@Data
public class AmazonProductCommentAnalysisResult {
    public AmazonProductComment amazonProductComment;
    public UserCommentMood userCommentMood;
    public boolean informative;
    public double weight;
}

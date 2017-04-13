package com.businessanalytics.analysis;

import com.businessanalytics.beans.content.Content;

/**
 * Created by srikanth on 13-04-2017.
 */
public interface AnalysisModule<T> {
    T run(Content content);
}

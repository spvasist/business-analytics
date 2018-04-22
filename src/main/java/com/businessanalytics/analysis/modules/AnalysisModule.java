package com.businessanalytics.analysis.modules;

/**
 * Created by srikanth on 13-04-2017.
 */
public interface AnalysisModule<I,O> {
    O run(I content);
}

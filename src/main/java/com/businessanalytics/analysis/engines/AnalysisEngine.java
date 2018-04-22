package com.businessanalytics.analysis.engines;

import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public interface AnalysisEngine<I, O> {
    public O run(I content);
}

package com.businessanalytics.beans.content;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
@Data
public class ToiContent implements Content {
    String headline;
    String authorAndDate;
    String body;

    @Override
    public String getData() {
        return body;
    }

    @Override
    public String getHeadline() {
        return headline;
    }
}

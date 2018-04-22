package com.businessanalytics.content.beans.toi;

import com.businessanalytics.content.beans.base.UserComment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
@Data
public class ToiNewsArticle {
    public String headline;
    public String body;
    public Date time;
    public String username;
}

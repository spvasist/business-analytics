package com.businessanalytics.content.beans.base;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
@Data
public class UserComment {
    public String title;
    public String body;
    public Date time;
    public String username;
    public List<UserComment> userComments;
}

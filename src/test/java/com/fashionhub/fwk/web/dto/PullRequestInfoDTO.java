package com.fashionhub.fwk.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PullRequestInfoDTO {

    private String name;
    private String createdDate;
    private String author;
}

package org.scoula.controller.ex03.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TodoDTO {
    private String title;

    @DateTimeFormat(pattern = "yyy/M/dd")
    private Date dueDate;
}

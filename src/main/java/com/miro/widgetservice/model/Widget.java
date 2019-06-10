package com.miro.widgetservice.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Value;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Value
@AllArgsConstructor
public class Widget {

    private static long ID_GENERATOR = 0;

    private long id;
    private Point coordinates;
    private int width;
    private int height;
    private int z;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastModification;

    @JsonCreator
    public Widget(Point coordinates, int width, int height, int z) {
        this(++ID_GENERATOR, coordinates, width, height, z, LocalDateTime.now());
    }

}

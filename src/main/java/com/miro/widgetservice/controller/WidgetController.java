package com.miro.widgetservice.controller;

import com.miro.widgetservice.model.Widget;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/widget-service")
@Api(value="widgetservice", description="Operations for managing widgets in the system")
public class WidgetController {

    private final static Logger log = Logger.getLogger(WidgetController.class);

    @PostMapping(value = "/create", produces = "application/json")
    @ApiOperation(value = "Creates a single widget")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Widget has been successfully created"),
            @ApiResponse(code = 400, message = "The provided parameter is invalid"),
            @ApiResponse(code = 401, message = "You are not authorized to create widgets"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden")})
    public Widget create(@RequestParam int x,
                         @RequestParam int y,
                         @RequestParam int width,
                         @RequestParam int height,
                         @RequestParam(required = false, defaultValue = "0") int z) {
        Widget newWidget = new Widget(new Point(x, y), width, height, z);
        log.info(newWidget);
        return newWidget;
    }

}

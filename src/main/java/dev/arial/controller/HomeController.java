package dev.arial.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.views.View;

@Controller("/")
public class HomeController {

    @View("index")
    @Get("/")
    public HttpResponse index() {
        return HttpResponse.ok(null);
    }
}
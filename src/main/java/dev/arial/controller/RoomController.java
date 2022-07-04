package dev.arial.controller;

import dev.arial.model.Room;
import dev.arial.repository.RoomRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;
import jakarta.inject.Inject;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Optional;

@Controller("/room")
public class RoomController {

    @Inject
    private RoomRepository roomRepository;

    @View("index")
    @Get("/create")
    @Transactional
    public HttpResponse createRoom() throws URISyntaxException {
        Room room = this.roomRepository.getFreeRoom().stream().findFirst().orElse(null);
        if (room == null) {
            return HttpResponse.ok(Collections.singletonMap("status", 1));
        }
        room.setStatus(false);
        this.roomRepository.save(room);
        return HttpResponse.redirect(new URI("/room/" + room.getId()));
    }
}

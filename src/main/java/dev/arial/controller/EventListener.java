package dev.arial.controller;

import dev.arial.model.Room;
import dev.arial.repository.RoomRepository;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.context.event.ShutdownEvent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.ArrayList;

@Singleton
public class EventListener {
    @Inject
    private RoomRepository roomRepository;

    @io.micronaut.runtime.event.annotation.EventListener
    public void onStartupEvent(StartupEvent event) {
        Iterable<Room> rooms = new ArrayList<Room>();
        for (int i = 0; i < 100; i++) {
            Room room = new Room();
            room.setStatus(true);
            roomRepository.save(room);
        }
        this.roomRepository.saveAll(rooms);
    }

    @io.micronaut.runtime.event.annotation.EventListener
    public void onShutdownEvent(ShutdownEvent event) {
        // shutdown logic here
    }
}
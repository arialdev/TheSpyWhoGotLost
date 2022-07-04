package dev.arial.repository;

import dev.arial.model.Room;
import io.micronaut.data.annotation.*;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    @Query("SELECT r FROM Room r WHERE r.status = true")
    List<Room> getFreeRoom();
}
package it.home.starter.repository;

import it.home.starter.controller.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BaseRepository<T extends BaseModel> extends JpaRepository<T, UUID> {
}

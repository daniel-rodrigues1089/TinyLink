package br.com.tinylink.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tinylink.api.models.Link;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Integer> {
    Optional<Link> findByCode(Integer code);
}

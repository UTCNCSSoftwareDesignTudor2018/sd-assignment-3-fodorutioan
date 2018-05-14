package com.osut.repository;

import com.osut.entity.Writer;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {
    List<Writer> findAll();
    Optional<Writer> findById(Long id);
    Optional<Writer> findByUsername(String username);
    Writer save(Writer writer);
}

package com.osut.service;

import com.osut.entity.Writer;
import com.osut.repository.WriterRepository;
import com.osut.service.validators.LogInValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    public List<Writer> getAllWriters() { return this.writerRepository.findAll(); }
    public Optional<Writer> getWriterByUsername(String username) { return this.writerRepository.findByUsername(username); }
    public Optional<Writer> getWriterById(Long id) { return this.writerRepository.findById(id); }
    public Writer save(Writer writer) { return this.writerRepository.save(writer); }

    public Writer logIn(String username, String password) {
        Writer writer = writerRepository.findByUsername(username).get();
        LogInValidator logInValidator = new LogInValidator();
        if (logInValidator.validateLogIn(writer, password)) {
            return writer;
        } else {
            return null;
        }
    }
}

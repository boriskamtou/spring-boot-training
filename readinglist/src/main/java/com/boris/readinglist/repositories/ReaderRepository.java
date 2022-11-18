package com.boris.readinglist.controllers;

import com.boris.readinglist.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, String> {

}

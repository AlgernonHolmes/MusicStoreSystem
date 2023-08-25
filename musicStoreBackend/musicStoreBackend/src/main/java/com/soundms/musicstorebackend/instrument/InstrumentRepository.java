package com.soundms.musicstorebackend.instrument;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

    /* abstract methods for springboot implementation */
    public Instrument getInstByid(Long id);
}

package com.aaronbujatin.delorianhotelbackend.repository;

import com.aaronbujatin.delorianhotelbackend.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {


}

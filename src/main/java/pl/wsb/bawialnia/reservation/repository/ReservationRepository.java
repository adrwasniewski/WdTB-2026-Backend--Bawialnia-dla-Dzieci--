package pl.wsb.bawialnia.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.bawialnia.reservation.entity.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByPlayRoom_Name(String name);
}
package pl.wsb.bawialnia.reservation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class ReservationPeriod {

    @Column(name = "starts_at", nullable = false)
    private LocalDateTime startsAt;

    @Column(name = "ends_at", nullable = false)
    private LocalDateTime endsAt;

    protected ReservationPeriod() {
    }

    public ReservationPeriod(LocalDateTime startsAt, LocalDateTime endsAt) {
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }

    public LocalDateTime getStartsAt() {
        return startsAt;
    }

    public LocalDateTime getEndsAt() {
        return endsAt;
    }
}
package pl.wsb.bawialnia.room.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

import jakarta.persistence.OneToMany;
import pl.wsb.bawialnia.reservation.entity.Reservation;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "play_room")
public class PlayRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "area", nullable = false, precision = 10, scale = 2)
    private BigDecimal area;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "playRoom")
    private List<Reservation> reservations = new ArrayList<>();

    protected PlayRoom() {
    }

    public PlayRoom(String name, Integer capacity, BigDecimal area, Boolean active) {
        this.name = name;
        this.capacity = capacity;
        this.area = area;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public BigDecimal getArea() {
        return area;
    }

    public Boolean getActive() {
        return active;
    }

    public List<Reservation> getReservations() { return reservations; }
}
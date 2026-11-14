package pl.wsb.bawialnia.reservation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pl.wsb.bawialnia.room.entity.PlayRoom;
import pl.wsb.bawialnia.offer.entity.Offer;
import pl.wsb.bawialnia.customer.entity.Customer;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import pl.wsb.bawialnia.extra.entity.Extra;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false, length = 80)
    private String customerName;

    @Column(name = "children_count", nullable = false)
    private Integer childrenCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ReservationStatus status;

    @Embedded
    private ReservationPeriod period;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "play_room_id", nullable = false)
    private PlayRoom playRoom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "offer_id", nullable = false)
    private Offer offer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "reservation_extra",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "extra_id")
    )
    private Set<Extra> extras = new HashSet<>();

    protected Reservation() {
    }

    public Reservation(
            String customerName,
            Integer childrenCount,
            ReservationStatus status,
            ReservationPeriod period,
            PlayRoom playRoom,
            Offer offer,
            Customer customer
    ) {
        this.customerName = customerName;
        this.childrenCount = childrenCount;
        this.status = status;
        this.period = period;
        this.playRoom = playRoom;
        this.offer = offer;
        this.customer = customer;
    }
    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Integer getChildrenCount() {
        return childrenCount;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public ReservationPeriod getPeriod() {
        return period;
    }

    public PlayRoom getPlayRoom() { return playRoom; }

    public Offer getOffer() { return offer; }

    public Set<Extra> getExtras() { return extras; }

    public Customer getCustomer() { return customer; }
}
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

    protected Reservation() {
    }

    public Reservation(
            String customerName,
            Integer childrenCount,
            ReservationStatus status,
            ReservationPeriod period
    ) {
        this.customerName = customerName;
        this.childrenCount = childrenCount;
        this.status = status;
        this.period = period;
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
}
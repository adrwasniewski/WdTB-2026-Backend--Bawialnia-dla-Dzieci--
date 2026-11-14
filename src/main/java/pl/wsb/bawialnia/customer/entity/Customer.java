package pl.wsb.bawialnia.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import pl.wsb.bawialnia.account.domain.UserAccount;

import java.time.LocalDate;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 80)
    private String fullName;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "registered_on", nullable = false)
    private LocalDate registeredOn;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id", unique = true)
    private UserAccount account;

    protected Customer() {
    }

    public Customer(
            String fullName,
            String phone,
            LocalDate registeredOn,
            Boolean active,
            UserAccount account
    ) {
        this.fullName = fullName;
        this.phone = phone;
        this.registeredOn = registeredOn;
        this.active = active;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public Boolean getActive() {
        return active;
    }

    public UserAccount getAccount() {
        return account;
    }
}
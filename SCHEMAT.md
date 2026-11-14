# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 7 (w tym tabele łączące @ManyToMany: reservation_extra) · kolumny: 35 · relacje: 3 × @ManyToOne, 1 × @OneToMany, 1 × @OneToOne, 1 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| customer | Customer | 6 | user_account_id |
| extra | Extra | 5 | — |
| offer | Offer | 5 | — |
| play_room | PlayRoom | 5 | — |
| reservation | Reservation | 9 | customer_id, offer_id, play_room_id |
| user_account | UserAccount | 5 | — |

```mermaid
erDiagram
    customer {
        Long id PK
        Boolean active
        String full_name
        String phone
        LocalDate registered_on
        Long user_account_id FK
    }
    extra {
        Long id PK
        Boolean active
        String description
        String name
        BigDecimal price
    }
    offer {
        Long id PK
        Boolean active
        Integer duration_minutes
        String name
        BigDecimal price
    }
    play_room {
        Long id PK
        Boolean active
        BigDecimal area
        Integer capacity
        String name
    }
    reservation {
        Long id PK
        Integer children_count
        Long customer_id FK
        String customer_name
        LocalDateTime ends_at
        Long offer_id FK
        Long play_room_id FK
        LocalDateTime starts_at
        ReservationStatus status
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    customer ||--o{ reservation : "customer_id"
    offer ||--o{ reservation : "offer_id"
    play_room ||--o{ reservation : "play_room_id"
    reservation }o--o{ extra : "reservation_extra"
    user_account |o--o| customer : "user_account_id"
```

-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('s289330@student.wroclaw.merito.pl',   'Dawid',   'USER',    current_timestamp),
    ('wrx105032@student.wroclaw.merito.pl',  'Adrian',  'USER',    current_timestamp),
    ('dumy123456@student.wroclaw.merito.pl',  'Dumy',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);

-- ===== LAB 02: sale zabaw =====

INSERT INTO play_room (name, capacity, area, active) VALUES
                                                         ('Sala Tęczowa', 15, 45.50, true),
                                                         ('Sala Leśna', 10, 32.00, true),
                                                         ('Sala Kosmiczna', 20, 60.00, false);


-- ===== LAB 02: oferty =====

INSERT INTO offer (name, price, duration_minutes, active) VALUES
                                                              ('Wejście godzinne', 35.00, 60, true),
                                                              ('Wejście dwugodzinne', 55.00, 120, true),
                                                              ('Pakiet urodzinowy', 350.00, 180, true);


-- ===== LAB 03: klienci =====

INSERT INTO customer
(full_name, phone, registered_on, active, user_account_id)
VALUES
    ('Firma Example', '600100200', '2026-11-14', true, 4 ),
    ('Jan Nowak', '600200300', '2026-11-14', true, null),
    ('Maria Wiśniewska', '600300400', '2026-11-14', true, null);



-- ===== LAB 02 i LAB 03: rezerwacje =====

INSERT INTO reservation
(customer_name, children_count, status, starts_at, ends_at,
 play_room_id, offer_id, customer_id)
VALUES
    ('Anna Kowalska', 8, 'NEW',
     '2026-11-14 10:00:00', '2026-11-14 12:00:00', 1, 2, 1),

    ('Jan Nowak', 12, 'CONFIRMED',
     '2026-11-15 14:00:00', '2026-11-15 17:00:00', 1, 3, 2),

    ('Maria Wiśniewska', 6, 'CANCELLED',
     '2026-11-16 11:00:00', '2026-11-16 13:00:00', 2, 2, 3);

-- ===== LAB 03: dodatki =====

INSERT INTO extra (name, price, description, active) VALUES
    ('Animator', 150.00, 'Zajęcia z animatorem', true),
    ('Tort urodzinowy', 120.00, 'Tort dla gości', true),
    ('Dekoracja sali', 80.00, 'Dekoracja tematyczna', true);




-- ===== LAB 03: dodatki do rezerwacji =====

INSERT INTO reservation_extra (reservation_id, extra_id) VALUES
    (1, 1),
    (2, 1),
    (2, 2),
    (2, 3),
    (3, 1);


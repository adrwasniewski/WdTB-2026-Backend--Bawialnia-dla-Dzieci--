-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('s289330@student.wroclaw.merito.pl',   'Dawid',   'USER',    current_timestamp),
    ('wrx105032@student.wroclaw.merito.pl',  'Adrian',  'USER',    current_timestamp),
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


-- ===== LAB 02: rezerwacje =====

INSERT INTO reservation
(customer_name, children_count, status, starts_at, ends_at)
VALUES
    ('Anna Kowalska', 8, 'NEW',
     '2026-11-14 10:00:00', '2026-11-14 12:00:00'),

    ('Jan Nowak', 12, 'CONFIRMED',
     '2026-11-15 14:00:00', '2026-11-15 17:00:00'),

    ('Maria Wiśniewska', 6, 'CANCELLED',
     '2026-11-16 11:00:00', '2026-11-16 13:00:00');
INSERT INTO address (id, address_line1, address_line2, city, postal_code) VALUES
    (1, 'xx', 'yy', 'city', '62-030'),
    (2, '123 Main St', 'Apt 101', 'New York', '10001'),
    (3, '456 Elm St', NULL, 'Los Angeles', '90001'),
    (4, '789 Oak St', 'Suite 201', 'Chicago', '60601'),
    (5, '101 Pine St', NULL, 'Houston', '77001'),
    (6, '202 Maple St', 'Apt 5B', 'Boston', '02115'),
    (7, '303 Cedar St', 'Floor 3', 'San Francisco', '94102'),
    (8, '404 Birch St', NULL, 'Seattle', '98101'),
    (9, '505 Ash St', 'Unit 10', 'Denver', '80203'),
    (10, '606 Walnut St', 'Suite 100', 'Miami', '33101');

INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, is_insured) VALUES
    (1, 'Emma', 'Johnson', '987654321', 'emma.j@example.com', 'P11', '1990-01-01', 1, TRUE),
    (2, 'John', 'Smith', '123456789', 'john.s@example.com', 'P12', '1985-06-15', 2, FALSE),
    (3, 'Olivia', 'Brown', '654321987', 'olivia.b@example.com', 'P13', '1980-03-20', 3, TRUE),
    (4, 'William', 'Davis', '789123456', 'william.d@example.com', 'P14', '1977-12-10', 4, FALSE),
    (5, 'Michael', 'Davis', '583423456', 'michael.william.d@example.com', 'P15', '2000-09-09', 5, TRUE),
    (6, 'Andrew', 'Davis', '889728476', 'andrew.d@example.com', 'P16', '1999-03-15', 6, TRUE),
    (7, 'Sophia', 'Williams', '453214987', 'sophia.w@example.com', 'P17', '1995-11-22', 7, FALSE),
    (8, 'James', 'Jones', '789654123', 'james.j@example.com', 'P18', '1973-05-05', 8, TRUE),
    (9, 'Isabella', 'Miller', '321654987', 'isabella.m@example.com', 'P19', '1988-02-14', 9, TRUE),
    (10, 'Mia', 'Wilson', '456987321', 'mia.w@example.com', 'P20', '1992-07-07', 10, FALSE);

INSERT INTO doctor (id, first_name, last_name, telephone_number, email, specialization, doctor_number, address_id) VALUES
    (1, 'Michael', 'Johnson', '987654321', 'michael.j@example.com', 'SURGEON', 'D11', 1),
    (2, 'Emily', 'Smith', '123456789', 'emily.s@example.com', 'GP', 'D12', 2),
    (3, 'David', 'Brown', '654321987', 'david.b@example.com', 'SURGEON',  'D13', 3),
    (4, 'Sarah', 'Davis', '789123456', 'sarah.d@example.com', 'DERMATOLOGIST', 'D14', 4),
    (5, 'Daniel', 'Lee', '112233445', 'daniel.l@example.com', 'DERMATOLOGIST', 'D15', 5),
    (6, 'Laura', 'Clark', '998877665', 'laura.c@example.com', 'GP', 'D16', 6),
    (7, 'Robert', 'Martinez', '443322110', 'robert.m@example.com', 'OCULIST', 'D17', 7);

INSERT INTO visit (id, description, time, doctor_id, patient_id) VALUES
    (1, 'Routine check-up', '2024-05-13 09:00:00', 1, 1),
    (2, 'Vaccination appointment', '2024-05-14 10:30:00', 2, 2),
    (3, 'Follow-up for knee surgery', '2024-05-15 14:00:00', 3, 3),
    (4, 'Skin condition evaluation', '2024-05-16 11:15:00', 4, 4),
    (5, 'Annual physical exam', '2024-05-17 09:00:00', 1, 5),
    (6, 'Consultation for stomach pain', '2024-05-18 10:00:00', 6, 6),
    (7, 'Blood pressure check', '2024-05-19 11:00:00', 5, 1),
    (8, 'Diabetes management follow-up', '2024-05-20 14:00:00', 7, 8),
    (9, 'Allergy testing', '2024-05-21 15:30:00', 4, 1),
    (10, 'Vaccination booster', '2024-05-22 16:00:00', 2, 10);

INSERT INTO medical_treatment (id, description, type, visit_id) VALUES
    (1, 'Prescription for blood pressure medication', 'USG', 1),
    (2, 'Administered flu vaccine', 'EKG', 2),
    (3, 'Physical therapy session', 'EKG', 3),
    (4, 'Prescribed ointment for skin condition', 'USG', 4),
    (5, 'General check-up and lab tests', 'EKG', 5),
    (6, 'Prescribed antacid medication', 'USG', 6),
    (7, 'Blood pressure monitoring', 'RTG', 7),
    (8, 'Insulin dosage adjustment', 'USG', 8),
    (9, 'Allergy shots', 'RTG', 9),
    (10, 'Administered tetanus booster', 'EKG', 10);

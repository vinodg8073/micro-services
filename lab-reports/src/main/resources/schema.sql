CREATE TABLE IF NOT EXISTS test_reports (
    id INT PRIMARY KEY,
    report_id INT NOT NULL,
    test_id INT NOT NULL,
    values VARCHAR(100) NOT NULL,
    created_date DATE NOT null,
    created_by VARCHAR(20) NOT NULL,
    updated_date DATE DEFAULT NULL,
    updated_by VARCHAR(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS lab_reports (
    report_id INT PRIMARY KEY,
    patient_id INT NOT NULL,
    issued INT NOT NULL DEFAULT 0,
    verified_by VARCHAR(50),
    tested_by VARCHAR(50) NOT NULL,
    payment_received INT NOT NULL DEFAULT 0,
    total_amount INT NOT NULL DEFAULT 0,
    received_amount INT NOT NULL DEFAULT 0,
    created_date DATE NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    updated_date DATE DEFAULT NULL,
    updated_by VARCHAR(20) DEFAULT NULL
);

truncate table lab_reports ;
INSERT INTO lab_reports (report_id, patient_id, issued, verified_by, tested_by, payment_received, total_amount, received_amount, created_date, created_by, updated_date, updated_by)
VALUES
    (1, 7001, 1, 'Dr. Uma', 'Tester1', 0, 0, 0, now(), 'Admin', NULL, NULL),
    (2, 7003, 0, 'Dr. ABC', 'Tester2', 0, 0, 0, now(), 'Admin', NULL, null),
    (3, 7003, 1, 'Dr. XYZ', 'Tester3', 0, 0, 0, '2024-04-25', 'Admin', now(), 'Admin');
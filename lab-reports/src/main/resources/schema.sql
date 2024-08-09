DROP TABLE IF EXISTS lab_report_test_details CASCADE;
DROP TABLE IF EXISTS lab_report_results CASCADE;
DROP TABLE IF EXISTS lab_reports CASCADE;
DROP TABLE IF EXISTS lab_tests CASCADE;
DROP TABLE IF EXISTS test_reports  CASCADE;

CREATE TABLE lab_tests (
    test_id BIGSERIAL PRIMARY KEY,
    test_name VARCHAR(255) NOT NULL
);

CREATE TABLE lab_reports (
    report_id BIGSERIAL PRIMARY KEY,
    patient_id BIGINT NOT NULL,
    verified_by VARCHAR(255),
    tested_by VARCHAR(255),
    issued INT NOT NULL,
    payment_received INT NOT NULL,
    total_amount DOUBLE PRECISION NOT NULL,
    received_amount DOUBLE PRECISION NOT NULL,
    created_date TIMESTAMP,
    created_by VARCHAR(255),
    updated_date TIMESTAMP,
    updated_by VARCHAR(255)
);

CREATE TABLE lab_report_results (
    id BIGSERIAL PRIMARY KEY,
    result TEXT,
    report_id BIGINT UNIQUE NOT NULL,
    FOREIGN KEY (report_id) REFERENCES lab_reports (report_id),
    created_date TIMESTAMP,
    created_by VARCHAR(255),
    updated_date TIMESTAMP,
    updated_by VARCHAR(255)
);

CREATE TABLE lab_report_test_details (
    report_test_id BIGSERIAL PRIMARY KEY,
    report_id BIGINT NOT NULL,
    test_id BIGINT NOT NULL,
    FOREIGN KEY (report_id) REFERENCES lab_reports (report_id),
    FOREIGN KEY (test_id) REFERENCES lab_tests (test_id),
    UNIQUE (report_id, test_id),
    created_date TIMESTAMP,
    created_by VARCHAR(255),
    updated_date TIMESTAMP,
    updated_by VARCHAR(255)
);

INSERT INTO lab_tests (test_name) VALUES
('Blood Test'),
('Urine Test'),
('X-Ray'),
('MRI'),
('CT Scan');

INSERT INTO lab_reports (patient_id, verified_by, tested_by, issued, payment_received, total_amount, received_amount, created_date, created_by, updated_date, updated_by) VALUES
(1, 'Dr. Smith', 'Dr. Johnson', 1, 0, 250.00, 250.00, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
(1, 'Dr. Adams', 'Dr. Lee', 0, 1, 150.00, 100.00, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
(3, 'Dr. Brown', 'Dr. Wilson', 1, 0, 300.00, 300.00, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');

INSERT INTO lab_report_results (result, report_id, created_date, created_by, updated_date, updated_by) VALUES
('Positive', 1, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('Negative', 2, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
('Positive', 3, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');

INSERT INTO lab_report_test_details (report_id, test_id, created_date, created_by, updated_date, updated_by) VALUES
(1, 1, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
(1, 3, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
(2, 2, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
(2, 4, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin'),
(3, 5, CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');
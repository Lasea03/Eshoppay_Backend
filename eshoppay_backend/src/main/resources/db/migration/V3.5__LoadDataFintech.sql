-- 1. Insert all data fintech
INSERT INTO fintech.fintechs (fint_code, fint_name, fint_short_name, fint_type)
VALUES
('002', 'Bank Rakyat Indonesia', 'BRI', 'BANK'),
('008', 'Bank Mandiri', 'MANDIRI', 'BANK'),
('009', 'Bank Negara Indonesia', 'BNI', 'BANK'),
('014', 'Bank Central Asia', 'BCA', 'BANK'),
('022', 'Bank CIMB Niaga', 'CIMB', 'BANK'),
('028', 'Bank OCBC NISP', 'OCBC', 'BANK'),
('426', 'Bank Mega', 'MEGA', 'BANK'),
('013', 'Bank Permata', 'PERMATA', 'BANK'),
('011', 'Bank Danamon', 'DANAMON', 'BANK'),
('016', 'Bank Maybank Indonesia', 'MAYBANK', 'BANK'),
('019', 'Bank Panin', 'PANIN', 'BANK'),
('023', 'Bank UOB Indonesia', 'UOB', 'BANK'),
('200', 'Bank Tabungan Negara', 'BTN', 'BANK'),
('045', 'Bank BTPN/Jago', 'BTPN/JAGO', 'BANK'),
('213', 'Bank BJB', 'BJB', 'BANK'),
('490', 'Bank Neo Commerce', 'NEO', 'BANK'),
('501', 'Bank Digital BCA (blu)', 'BCA DIGITAL', 'BANK'),
('503', 'Bank Jago', 'JAGO', 'BANK'),
('506', 'Bank Seabank', 'SEABANK', 'BANK'),
('890', 'Dana', 'DANA', 'E-Wallet'),
('991', 'OVO', 'OVO', 'E-Wallet'),
('992', 'LinkAja', 'LINKAJA', 'E-Wallet'),
('993', 'GoPay', 'GOPAY', 'E-Wallet'),
('994', 'ShopeePay', 'SHOPEEPAY', 'E-Wallet'),
('995', 'Flip', 'FLIP', 'P-GateAway'),
('998', 'Jenius (BTPN) Digital Banking', 'JENIUS', 'E-Wallet');

-- 2. Set sequence start to 300 (karena akun sebelumnya kita skip)
ALTER SEQUENCE fintech.accounts_account_id_seq
RESTART WITH 300 INCREMENT BY 1;

-- 3. User accounts (hanya untuk user_id yang sudah ada)
INSERT INTO fintech.accounts (account_no, balance, currency, user_id, fin_code)
VALUES
('008-133465789', 1000000, 'IDR', 66, '008'),
('014-567898765', 2000000, 'IDR', 66, '014'),
('993-456789876', 0, 'IDR', 66, '993'),
('008-321123456', 1000000, 'IDR', 68, '008'),
('014-876567890', 2000000, 'IDR', 68, '008'),
('994-456789876', 20000, 'IDR', 68, '994');

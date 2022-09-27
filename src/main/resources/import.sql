insert into Profile values (1, 'ROLE_ADMIN');
insert into Profile values (2, 'ROLE_TEST');
insert into User_Account (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username) values (1, true, true, true, true, '$2a$10$fwQJT.ABmklx9fNU3nunuO5Jkc7aloQK0UZQwVS0stt.Zg6y3hGxi', 'matheus');
insert into User_Account (id, account_non_expired, account_non_locked, credentials_non_expired, enabled, password, username) values (2, true, true, true, true, '$2a$10$fwQJT.ABmklx9fNU3nunuO5Jkc7aloQK0UZQwVS0stt.Zg6y3hGxi', 'test');
insert into User_Profile (id, user_account_id, profile_id) values (1, SELECT id FROM User_Account WHERE USERNAME = 'matheus', SELECT ID FROM Profile WHERE permission = 'ROLE_ADMIN');
insert into User_Profile (id, user_account_id, profile_id) values (2, SELECT id FROM User_Account WHERE USERNAME = 'test', SELECT ID FROM Profile WHERE permission = 'ROLE_TEST');
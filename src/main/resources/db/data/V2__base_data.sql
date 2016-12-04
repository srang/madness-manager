SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO states SET
  state_id = 1,
  state = 'setup',
  next_id = 2,
  prev_id = null
;
INSERT INTO states SET
  state_id = 2,
  state = 'submission',
  next_id = 3,
  prev_id = 1
;
INSERT INTO states SET
  state_id = 3,
  state = 'active',
  next_id = 4,
  prev_id = 2
;
INSERT INTO states SET
  state_id = 4,
  state = 'complete',
  next_id = 4,
  prev_id = 3
;


INSERT INTO statuses SET
  status_id = 1,
  status = 'unverified'
;
INSERT INTO statuses SET
  status_id = 2,
  status = 'active'
;
INSERT INTO statuses SET
  status_id = 3,
  status = 'disabled'
;
INSERT INTO statuses SET
  status_id = 4,
  status = 'expired'
;

INSERT INTO regions SET
  region_id = 1,
  region = 'East'
;
INSERT INTO regions SET
  region_id = 2,
  region = 'West'
;
INSERT INTO regions SET
  region_id = 3,
  region = 'South'
;
INSERT INTO regions SET
  region_id = 4,
  region = 'Midwest'
;
INSERT INTO regions SET
  region_id = 5,
  region = ''
;

INSERT INTO statuses SET
  status = 'unverified'
;
INSERT INTO statuses SET
  status = 'active'
;
INSERT INTO statuses SET
  status = 'disabled'
;
INSERT INTO statuses SET
  status = 'expired'
;


SELECT @statusid := status_id from statuses where status='active';
INSERT INTO users SET
  first_name = 'sam',
  last_name = 'rang',
  email = 'f',
  password = 'f',
  status_id = @statusid
;
INSERT INTO users SET
  first_name = 'sam',
  last_name = 'blah',
  email = 'ff',
  password = 'f',
  status_id = @statusid
;
INSERT INTO users SET
  first_name = 'asdf',
  last_name = 'rang',
  email = 'fj',
  password = 'f',
  status_id = @statusid
;
INSERT INTO users SET
  first_name = 'ff',
  last_name = 'rang',
  email = 'JJJ',
  password = 'f',
  status_id = @statusid
;


SET FOREIGN_KEY_CHECKS = 1;
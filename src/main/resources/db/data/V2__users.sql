INSERT INTO statuses SET
  status = 'active'
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
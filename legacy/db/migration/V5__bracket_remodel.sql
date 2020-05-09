SET FOREIGN_KEY_CHECKS = 0;

drop table brackets;
drop table games;

CREATE TABLE games (
  game_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  team_a int(10) unsigned NOT NULL,
  team_b int(10) unsigned NOT NULL,
  score_a int(11) DEFAULT NULL,
  score_b int(11) DEFAULT NULL,
  round_id int(10) unsigned NOT NULL,
  game_index int(10) unsigned NOT NULL,
  bracket_id int(10) unsigned NOT NULL,
  created_at timestamp NULL DEFAULT NULL,
  updated_at timestamp NULL DEFAULT NULL,
  PRIMARY KEY (game_id),
  KEY games_team_a_foreign (team_a),
  KEY games_team_b_foreign (team_b),
  KEY games_round_id_index (round_id),
  KEY games_game_index_index (game_index),
  KEY games_bracket_id_index (bracket_id),
  CONSTRAINT games_bracket_foreign FOREIGN KEY (bracket_id) REFERENCES brackets (bracket_id),
  CONSTRAINT games_team_a_foreign FOREIGN KEY (team_a) REFERENCES teams (team_id),
  CONSTRAINT games_team_b_foreign FOREIGN KEY (team_b) REFERENCES teams (team_id)
);

CREATE TABLE brackets (
  bracket_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  user_id int(10) unsigned DEFAULT NULL,
  name varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  master tinyint(1) NOT NULL DEFAULT '0',
  created_at timestamp NULL DEFAULT NULL,
  updated_at timestamp NULL DEFAULT NULL,
  PRIMARY KEY (bracket_id),
  KEY brackets_user_id_foreign (user_id),
  CONSTRAINT brackets_user_id_foreign FOREIGN KEY (user_id) REFERENCES users (user_id)
);

SET FOREIGN_KEY_CHECKS = 1;

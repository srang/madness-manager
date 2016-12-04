SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO states
  (state_id, state, next_id, prev_id)
VALUES
  (1,'setup',2,NULL),
  (2,'submission',3,1),
  (3,'active',4,2),
  (4,'complete',4,3)
;

INSERT INTO statuses
  (status_id, status)
VALUES
  (1,'unverified'),
  (2,'active'),
  (3,'disabled'),
  (4,'expired')
;

INSERT INTO regions
  (region_id, region)
VALUES
  (1,'East'),
  (2,'West'),
  (3,'South'),
  (4,'Midwest'),
  (5,'')
;

SELECT @statusid := status_id from statuses where status='active';

INSERT INTO users
  (first_name,last_name,email,status_id,password)
VALUES
  ('Sam','Rang','test@email.com',2,'password')
;

INSERT INTO rulesets
  (name, desc)
VALUES
  ('Bull Moose','The bull moose rule set')
;
SELECT @rs_id = ruleset_id FROM rulesets WHERE name = 'Bull Moose';

INSERT INTO rules
  (ruleset_id, round_id, rule)
VALUES
  (@rs_id,1,'$RANK'),
  (@rs_id,2,'$RANK * $ROUND'),
  (@rs_id,3,'$RANK * $ROUND + 10'),
  (@rs_id,4,'$RANK * $ROUND + 25'),
  (@rs_id,5,'$RANK * $ROUND + 40'),
  (@rs_id,6,'$RANK * $ROUND + 65')
;

INSERT INTO bonusrules
  (ruleset_id, rule)
VALUES
  (@rs_id, 'ScoreFinalFourBonusRuleStrategy')
;

INSERT INTO `teams`
  (name,region_id,mascot,icon_path,primary_color,accent_color)
VALUES
  ('Oklahoma',5,'Sooners','/path/to/icon','000000','ffffff'),
  ('Oregon',5,'Ducks','/path/to/icon','008000','ffff00'),
  ('Villanova',5,'Wildcats','/path/to/icon','000085','ffffff'),
  ('Kansas',5,'Jayhawks','/path/to/icon','0000ff','ff0000'),
  ('Maryland',5,'Terrapins','/path/to/icon','f50000','ffffff'),
  ('Virginia',5,'Cavaliers','/path/to/icon','0000b3','ff6600'),
  ('Iowa',5,'Hawkeyes','/path/to/icon','000000','ffff00'),
  ('Xavier',5,'Musketeers','/path/to/icon','0000a3','ffffff'),
  ('West Virginia',5,'Mountaineers','/path/to/icon','0000d1','ffff00'),
  ('North Carolina',5,'Tarheels','/path/to/icon','7a7aff','ffffff'),
  ('SMU',5,'Mustangs','/path/to/icon','e00000','0000ff'),
  ('Miami (FL)',5,'Hurricanes','/path/to/icon','008000','ff6600'),
  ('Dayton',5,'Flyers','/path/to/icon','0000f5','ff0000'),
  ('Iowa State',5,'Cyclones','/path/to/icon','ff0000','ffff00'),
  ('Kentucky',5,'Wildcats','/path/to/icon','0000ff','ffffff'),
  ('Utah',5,'Utes','/path/to/icon','ff0000','ffffff'),
  ('Michigan State',5,'Spartans','/path/to/icon','006100','ffffff'),
  ('USC',5,'Trojans','/path/to/icon','d60000','ffff00'),
  ('Texas A&M',5,'Aggies','/path/to/icon','ad0000','ffffff'),
  ('Texas',5,'Longhorns','/path/to/icon','bd4b00','ffffff'),
  ('Purdue',5,'Boilermakers','/path/to/icon','000000','ffff00'),
  ('Duke',5,'Blue Devils','/path/to/icon','0000cc','ffffff'),
  ('Florida',5,'Gators','/path/to/icon','0000d6','ff6600'),
  ('Notre Dame',5,'Fighting Irish','/path/to/icon','0000a8','dbdb00'),
  ('Louisville',5,'Cardinals','/path/to/icon','ff0000','000000'),
  ('Baylor',5,'Bears','/path/to/icon','006600','ffff00'),
  ('Colorado',5,'Buffalos','/path/to/icon','000000','9e9e00'),
  ('South Carolina',5,'Gamecocks','/path/to/icon','b80000','ffffff'),
  ('Arizona',5,'Wildcats','/path/to/icon','00008f','ff0000'),
  ('Saint Joseph\'s',5,'Hawks','/path/to/icon','b80000','ffffff'),
  ('Oregon State',5,'Beavers','/path/to/icon','ff6600','000000'),
  ('Providence',5,'Friars','/path/to/icon','000000','ffffff'),
  ('California',5,'Bears','/path/to/icon','ffff00','0000d1'),
  ('George Washington',5,'Colonials','/path/to/icon','ffff00','0000ff'),
  ('Monmouth',5,'Hawks','/path/to/icon','7a7aff','ffffff'),
  ('Chattanooga',5,'Mocs','/path/to/icon','ffff00','0000ff'),
  ('Seton Hall',5,'Pirates','/path/to/icon','0000ff','ffffff'),
  ('Kansas State',5,'Wildcats','/path/to/icon','800080','ffffff'),
  ('Florida State',5,'Seminoles','/path/to/icon','a80000','8f8f00'),
  ('Pittsburgh',5,'Panthers','/path/to/icon','ffff00','0000a8'),
  ('VCU',5,'Rams','/path/to/icon','ffff00','000000'),
  ('William & Mary',5,'Tribe','/path/to/icon','ffff00','008000'),
  ('Wichita St',5,'Shockers','/path/to/icon','000000','ffff00'),
  ('Akron',5,'Zipa','/path/to/icon','757500','0000a3'),
  ('St Bonaventure',5,'Bonnies','/path/to/icon','421b00','999999'),
  ('Syracuse',5,'Orangemen','/path/to/icon','ff6600','ffffff'),
  ('San Diego State',5,'Aztecs','/path/to/icon','000000','ff0000'),
  ('Connecticut',5,'Huskies','/path/to/icon','00008a','ffffff'),
  ('South Dakota State',5,'Jackrabbits','/path/to/icon','ffff00','0000ff'),
  ('Valparaiso',5,'Crusaders','/path/to/icon','ffff00','612700'),
  ('Texas Tech',5,'Red Raiders','/path/to/icon','ff0000','000000'),
  ('Alabama',5,'Crimson Tide','/path/to/icon','a30000','ffffff'),
  ('Indiana',5,'Hoosiers','/path/to/icon','a30000','ffffff'),
  ('Davidson',5,'Wildcats','/path/to/icon','ff0000','ffffff'),
  ('Saint Mary\'s',5,'Gaels','/path/to/icon','0000ff','ff0000'),
  ('Michigan',5,'Wolverines','/path/to/icon','0000c7','e0e000'),
  ('Washington',5,'Huskies','/path/to/icon','800080','999900'),
  ('Vanderbilt',5,'Commodores','/path/to/icon','000000','b2b300'),
  ('Princeton',5,'Tigers','/path/to/icon','000000','ff6600'),
  ('Cincinnati',5,'Bearcats','/path/to/icon','000000','a30000'),
  ('Arkansas-Little Rock',5,'Trojans','/path/to/icon','610000','ffffff'),
  ('Wisconsin',5,'Badgers','/path/to/icon','eb0000','ffffff'),
  ('Yale',5,'Eli','/path/to/icon','0000c2','ffffff'),
  ('Gonzaga',5,'Bulldogs','/path/to/icon','0000ff','bdbdbd'),
  ('Tulsa',5,'Golden Hurricanes','/path/to/icon','0000ff','ff0000'),
  ('Stony Brook',5,'Seawolves','/path/to/icon','ff0000','ffffff'),
  ('Butler',5,'Bulldogs','/path/to/icon','000000','5c5cff'),
  ('UCLA',5,'Bruins','/path/to/icon','0000ff','ffff00'),
  ('Georgia',5,'Bulldogs','/path/to/icon','000000','ff0000'),
  ('Temple',5,'Owls','/path/to/icon','9e0000','ffffff'),
  ('Stanford',5,'Cardinal','/path/to/icon','ad0000','ffffff'),
  ('UC Irvine',5,'Anteaters','/path/to/icon','ffff00','0000ff'),
  ('Arizona State',5,'Sun Devils','/path/to/icon','9e3f00','949400'),
  ('Middle Tennessee',5,'Blue Raiders','/path/to/icon','4d4dff','b8b8b8'),
  ('Georgetown',5,'Hoyas','/path/to/icon','a1a1a1','000085'),
  ('LSU',5,'Tigers','/path/to/icon','9e9e00','0000ff'),
  ('UNC Wilmington',5,'Seahawks','/path/to/icon','0000ff','ffff00'),
  ('Hofstra',5,'Pride','/path/to/icon','7575ff','ffffff'),
  ('Ohio State',5,'Buckeyes','/path/to/icon','a1a1a1','ff0000'),
  ('Georgia Tech',5,'Yellow Jackets','/path/to/icon','000000','a8a800'),
  ('TBD',5,'','/path/to/icon','AAA','000'),
  ('TBD',5,'','/path/to/icon','AAA','000'),
  ('TBD',5,'','/path/to/icon','AAA','000'),
  ('TBD',5,'','/path/to/icon','AAA','000'),
  ('Belmont',5,'Bruins','/path/to/icon','0000ff','ff0000'),
  ('Bucknell',5,'Bison','/path','0000ff','ff6600'),
  ('Hampton',5,'Pirates','/path','0000ff','ffffff'),
  ('Hawaii',5,'Rainbow Warriors','/path','004d00','ffffff'),
  ('New Mexico State',5,'Aggies','/path','000000','ffffff'),
  ('North Florida',5,'Ospreys','/path','6161ff','ffffff'),
  ('Stephen F. Austin',5,'Lumberjacks','/path','800080','ffffff'),
  ('Texas Southern',5,'Tigers','/path','b3b3b3','ff0000'),
  ('UAB',5,'Blazers','/path','008000','ff0000'),
  ('Wagner',5,'Seahawks','/path','008000','ffffff'),
  ('Weber State',5,'Wildcats','/path','800080','c4c4c4'),
  ('Winthrop',5,'Eagles','/path','cc5200','ffff00')
;


SET FOREIGN_KEY_CHECKS = 1;
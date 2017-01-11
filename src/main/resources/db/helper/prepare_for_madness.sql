update teams set region_id=5, rank = team_id%16+1;
update teams set region_id=1 where team_id >  95 AND team_id <112;
update teams set region_id=2 where team_id > 111 AND team_id <128;
update teams set region_id=3 where team_id > 127 AND team_id <144;
update teams set region_id=4 where team_id > 144 AND team_id <160;
update teams set rank = null where region_id = 5;
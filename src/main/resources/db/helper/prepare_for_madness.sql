update teams set region_id=5, rank = (team_id-1)%16+1;
update teams set region_id=1 where team_id >  96 AND team_id <113;
update teams set region_id=2 where team_id > 112 AND team_id <129;
update teams set region_id=3 where team_id > 128 AND team_id <145;
update teams set region_id=4 where team_id > 144 AND team_id <161;
update teams set rank = null where region_id = 5;
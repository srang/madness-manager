import {Component, OnInit} from '@angular/core';
import {Team} from '../team';
import {TeamService} from '../team.service';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.sass']
})
export class TeamsComponent implements OnInit {

  teams: Team[];
  selectedTeam: Team;

  constructor(private teamService: TeamService) {
  }

  getTeams(): void {
    this.teamService.getTeams().subscribe(teams => this.teams = teams);
  }

  onSelect(team: Team): void {
    this.selectedTeam = team;
  }

  ngOnInit(): void {
    this.getTeams();
  }

}

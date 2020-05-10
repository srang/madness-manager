import {Component, OnInit} from '@angular/core';
import {Team} from '../team';
import {TEAMS} from '../mock-teams';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.sass']
})
export class TeamsComponent implements OnInit {

  teams = TEAMS;
  selectedTeam: Team;

  constructor() {
  }

  onSelect(team: Team): void {
    this.selectedTeam = team;
  }

  ngOnInit(): void {
  }

}

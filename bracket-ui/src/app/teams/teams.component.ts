import {Component, OnInit} from '@angular/core';
import {Team} from '../team';
import {TeamService} from '../team.service';
import {MessageService} from '../message.service';

@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.sass']
})
export class TeamsComponent implements OnInit {

  teams: Team[];

  constructor(private teamService: TeamService, private messageService: MessageService) {
  }

  getTeams(): void {
    this.teamService.getTeams().subscribe(teams => this.teams = teams);
  }

  add(name: string, primaryColor: string): void {
    name = name.trim();
    primaryColor = primaryColor.trim();
    if (!name || !primaryColor) {
      return;
    }
    this.teamService.addTeam({name, primaryColor} as Team)
      .subscribe(team => this.teams.push(team));
  }

  delete(team: Team): void {
    this.teamService.deleteTeam(team)
      .subscribe(() => this.teams = this.teams.filter(t => t !== team));
  }

  ngOnInit(): void {
    this.getTeams();
  }

}

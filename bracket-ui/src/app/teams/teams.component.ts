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

  ngOnInit(): void {
    this.getTeams();
  }

}

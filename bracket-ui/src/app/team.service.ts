import {Injectable} from '@angular/core';
import {Team} from './team';
import {TEAMS} from './mock-teams';
import {Observable, of} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor() {
  }

  getTeams(): Observable<Team[]> {
    return of(TEAMS);
  }
}

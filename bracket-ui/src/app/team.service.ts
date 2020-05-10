import {Injectable} from '@angular/core';
import {Team} from './team';
import {Observable, of} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import {MessageService} from './message.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  private teamsUrl = 'api/teams';
  private httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private http: HttpClient,
    private messageService: MessageService) {
  }

  private log(message: string) {
    this.messageService.add(`TeamService: ${message}`);
  }

  getTeams(): Observable<Team[]> {
    return this.http.get<Team[]>(this.teamsUrl)
      .pipe(
        tap(_ => this.log('fetched teams')),
        catchError(this.handleError<Team[]>('getTeams', []))
      );
  }

  getTeam(id: number): Observable<Team> {
    return this.http.get<Team>(`${this.teamsUrl}/id/${id}`)
      .pipe(
        tap(_ => this.log(`fetched team for id=${id}`)),
        catchError(this.handleError<Team>(`getTeam id=${id}`))
      );
  }

  updateTeam(team: Team): Observable<Team> {
    return this.http.put(`${this.teamsUrl}/id/${team.id}`, team, this.httpOptions)
      .pipe(
        tap(_ => this.log(`updating team id=${team.id}`)),
        catchError(this.handleError<any>('updateTeam'))
      );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
}

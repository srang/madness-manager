import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TeamsComponent} from './teams/teams.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {TeamDetailComponent} from './team-detail/team-detail.component';

const routes: Routes = [
  {path: 'teams', component: TeamsComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'detail/:id', component: TeamDetailComponent},
  {path: '', redirectTo: '/dashboard', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}

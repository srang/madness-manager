import {NgModule} from '@angular/core';

import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {AppComponent} from './app.component';
import {AppMaterialModule} from './app-material.module';
import {AppRoutingModule} from './app-routing.module';
import { BracketNavComponent } from './bracket-nav/bracket-nav.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {MessagesComponent} from './messages/messages.component';
import {TeamDetailComponent} from './team-detail/team-detail.component';
import {TeamsComponent} from './teams/teams.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    MessagesComponent,
    TeamsComponent,
    TeamDetailComponent,
    BracketNavComponent,
  ],
  imports: [
    AppMaterialModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

import {Component, OnInit} from '@angular/core';


import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import {Title} from "@angular/platform-browser";
import SockJS from "sockjs-client";
import Stomp from "stompjs"
import $ from "jquery";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  url = 'http://localhost:8080/websocket';
  client: any;

  constructor(private title: Title) {
    this.connection();
  }
  ngOnInit(): void {
    this.title.setTitle('Angular Spring WebSocket');

  }

  private connection() {
    let ws = new SockJS(this.url);
    this.client = Stomp.over(ws);
    let that: any = this;

    this.client.connect({}, function (frame: any) {
      that.client.subscribe("/topic/greeting", (message: any) =>{
        if(message.body){
          $(".msg").html(message.body)
        }
      })
    })
  }
}

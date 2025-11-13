import { Component } from '@angular/core';
import { ChatComponent } from './chat/chat.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ChatComponent],
  template: `
    <div class="wrapper">
      <h1 class="title">✨ Chatbot</h1>
      <app-chat></app-chat>
    </div>
  `,
  styles: [`
    .wrapper {
      max-width: 900px;
      margin: 40px auto;
      padding: 20px;
      background: rgba(255,255,255,0.05);
      border-radius: 12px;
    }
    .title {
      text-align: center;
      color: white;
      margin-bottom: 20px;
    }
  `]
})
export class AppComponent {}

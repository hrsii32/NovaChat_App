import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ChatService } from '../services/chat.service';

interface Message {
  from: 'user' | 'bot' | 'system';
  text: string;
  ts?: string;
}

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [CommonModule, FormsModule],
  providers: [ChatService],
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent {

  userMessage = '';
  messages: Message[] = [];
  loading = false;
  error = '';

  constructor(private chatService: ChatService) {
    this.messages.push({ from: 'system', text: 'Say hello — I am connected to Gemini.' });
  }

  sendMessage() {
    const text = this.userMessage.trim();
    if (!text) return;

    this.messages.push({
      from: 'user',
      text,
      ts: new Date().toISOString()
    });

    this.userMessage = '';
    this.loading = true;

    this.chatService.sendMessage(text).subscribe({
      next: (res) => {
        this.messages.push({
          from: 'bot',
          text: res.reply ?? 'No reply'
        });
        this.loading = false;
      },
      error: () => {
        this.messages.push({
          from: 'bot',
          text: 'Server error'
        });
        this.loading = false;
      }
    });
  }
}

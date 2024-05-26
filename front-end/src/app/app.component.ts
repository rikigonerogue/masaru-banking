import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [MatButtonModule, MatToolbarModule, RouterOutlet],
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'masaru-banking';
}

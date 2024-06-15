import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent {
  amount: number = 0;

  constructor(private transactionService: TransactionService, private router: Router) {}

  deposit() {
    this.transactionService.deposit(this.amount).subscribe(() => {
      this.router.navigate(['/main-page']);
    });
  }
}




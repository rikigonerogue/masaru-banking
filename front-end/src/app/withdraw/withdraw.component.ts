import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TransactionService } from '../transaction.service';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent {
  amount: number = 0;

  constructor(private transactionService: TransactionService, private router: Router) {}

  withdraw() {
    this.transactionService.withdraw(this.amount).subscribe(() => {
      this.router.navigate(['/main-page']);
    });
  }
}




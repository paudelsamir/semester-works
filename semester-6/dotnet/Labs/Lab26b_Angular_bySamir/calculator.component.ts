import { Component } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent {
  number1: number = 0;
  number2: number = 0;
  operation: string = 'add';
  result: number | null = null;
  operationPerformed: boolean = false;

  compute(): void {
    this.operationPerformed = false;
    
    switch(this.operation) {
      case 'add':
        this.result = this.number1 + this.number2;
        break;
      case 'subtract':
        this.result = this.number1 - this.number2;
        break;
      case 'multiply':
        this.result = this.number1 * this.number2;
        break;
      default:
        this.result = null;
    }
    
    this.operationPerformed = true;
  }

  clear(): void {
    this.number1 = 0;
    this.number2 = 0;
    this.operation = 'add';
    this.result = null;
    this.operationPerformed = false;
  }
}

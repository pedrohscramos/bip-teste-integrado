import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { BeneficioStore } from '../../state/beneficio.store';

@Component({
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="container mt-4">
      <h2>Transferência entre Benefícios</h2>

      <div *ngIf="store.message()" class="alert alert-success">
        {{ store.message() }}
      </div>

      <div *ngIf="store.error()" class="alert alert-danger">
        {{ store.error() }}
      </div>

      <form (ngSubmit)="transfer()">
        <div class="mb-3">
          <label>Origem</label>
          <select
            class="form-control"
            [(ngModel)]="model.fromId"
            name="fromId"
            required
          >
            <option *ngFor="let b of store.beneficios()" [value]="b.id">
              {{ b.nome }} ({{ b.valor | currency: 'BRL' }})
            </option>
          </select>
        </div>

        <div class="mb-3">
          <label>Destino</label>
          <select
            class="form-control"
            [(ngModel)]="model.toId"
            name="toId"
            required
          >
            <option *ngFor="let b of store.beneficios()" [value]="b.id">
              {{ b.nome }} ({{ b.valor | currency: 'BRL' }})
            </option>
          </select>
        </div>

        <div class="mb-3">
          <label>Valor</label>
          <input
            type="number"
            class="form-control"
            [(ngModel)]="model.amount"
            name="amount"
            required
          />
        </div>

        <button class="btn btn-primary">Transferir</button>
        <a class="btn btn-secondary ms-2" href="#">Cancelar</a>
      </form>
    </div>
  `,
})
export class TransferComponent implements OnInit {
  model = {
    fromId: 0,
    toId: 0,
    amount: 0,
  };

  constructor(public store: BeneficioStore) {}

  ngOnInit() {
    this.store.load();
  }

  transfer() {
    if (this.model.fromId === this.model.toId) {
      this.store.error.set('Origem e destino não podem ser iguais');
      return;
    }

    this.store.transfer(this.model);
  }
}

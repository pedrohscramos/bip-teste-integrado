import { Component, effect } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BeneficioStore } from '../../state/beneficio.store';

@Component({
  standalone: true,
  selector: 'app-list',
  imports: [CommonModule, RouterModule],
  template: `
    <div class="container mt-4">
      <h2>Benefícios</h2>

      <button class="btn btn-primary mb-3" routerLink="/create">
        Novo Benefício
      </button>

      <div *ngIf="store.loading()">Carregando...</div>

      <table class="table table-striped" *ngIf="!store.loading()">
        <tr *ngFor="let b of store.beneficios()">
          <td>{{ b.nome }}</td>
          <td>{{ b.descricao }}</td>
          <td>{{ b.valor | currency: 'BRL' }}</td>
          <td>
            <button class="btn btn-danger mb-3 ms-2" (click)="delete(b.id!)">
              Excluir
            </button>
            <button class="btn btn-warning mb-3 ms-2" routerLink="/transfer">
              Transferir
            </button>
          </td>
        </tr>
      </table>
    </div>
  `,
})
export class ListComponent {
  constructor(public store: BeneficioStore) {
    this.store.load();
  }

  delete(id: number) {
    this.store.remove(id);
  }
}

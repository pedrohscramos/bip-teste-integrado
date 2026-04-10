import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { BeneficioStore } from '../../state/beneficio.store';

@Component({
  standalone: true,
  imports: [FormsModule],
  template: `
    <div class="container mt-4">
      <h2>Novo Benefício</h2>

      <form (ngSubmit)="save()">
        <input
          class="form-control mb-2"
          [(ngModel)]="model.nome"
          name="nome"
          placeholder="Nome"
          required
        />
        <input
          class="form-control mb-2"
          [(ngModel)]="model.descricao"
          name="descricao"
          placeholder="Descrição"
        />
        <input
          type="number"
          class="form-control mb-2"
          [(ngModel)]="model.valor"
          name="valor"
          required
        />

        <button class="btn btn-success">Salvar</button>
        <a class="btn btn-secondary ms-2" href="#">Cancelar</a>
      </form>
    </div>
  `,
})
export class CreateComponent {
  model = {
    nome: '',
    descricao: '',
    valor: 0,
  };

  constructor(
    private store: BeneficioStore,
    private router: Router,
  ) {}

  save() {
    this.store.add(this.model);
    this.router.navigate(['/']);
  }
}

import { Injectable, signal } from '@angular/core';
import { Beneficio } from '../../../core/models/beneficio.model';
import { BeneficioService } from '../../../core/services/beneficio.service';
import { TransferRequest } from '../../../core/models/transfer-request.model';

@Injectable({ providedIn: 'root' })
export class BeneficioStore {
  beneficios = signal<Beneficio[]>([]);
  loading = signal(false);
  message = signal<string | null>(null);
  error = signal<string | null>(null);

  constructor(private service: BeneficioService) {}

  load() {
    this.loading.set(true);

    this.service.getAll().subscribe({
      next: (data) => {
        this.beneficios.set(data);
        this.loading.set(false);
      },
      error: (err) => {
        this.error.set(err.message);
        this.loading.set(false);
      },
    });
  }

  add(data: Beneficio) {
    this.service.create(data).subscribe({
      next: () => {
        this.message.set('Operação realizada com sucesso');
        this.load();
      },
      error: (err) => {
        this.error.set(err.message);
      },
    });
  }

  remove(id: number) {
    this.service.delete(id).subscribe({
      next: (res) => {
        this.message.set('Operação realizada com sucesso');
        this.load();
      },
    });
  }

  transfer(data: TransferRequest) {
    this.loading.set(true);

    this.service.transfer(data).subscribe({
      next: (res) => {
        this.message.set('Transferência realizada com sucesso');
        this.load();
        this.loading.set(false);
      },
      error: (err) => {
        this.error.set(err.message);
        this.loading.set(false);
      },
    });
  }
}

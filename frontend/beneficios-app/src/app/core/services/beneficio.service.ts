import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Beneficio } from '../models/beneficio.model';
import { TransferRequest } from '../models/transfer-request.model';

@Injectable({
  providedIn: 'root',
})
export class BeneficioService {
  private http = inject(HttpClient);
  private api = 'http://localhost:8080/api/v1/beneficios';

  getAll() {
    return this.http.get<Beneficio[]>(this.api);
  }

  create(data: Beneficio) {
    return this.http.post<void>(this.api, data);
  }

  delete(id: number) {
    return this.http.delete<void>(`${this.api}/${id}`);
  }

  transfer(data: TransferRequest) {
    return this.http.put<string>(this.api, data);
  }
}

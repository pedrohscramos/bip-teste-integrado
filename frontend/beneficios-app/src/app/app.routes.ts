import { Routes } from '@angular/router';
import { ListComponent } from './features/beneficios/pages/list/list.component';
import { CreateComponent } from './features/beneficios/pages/create/create.component';
import { TransferComponent } from './features/beneficios/pages/transfer/transfer.component';

export const routes: Routes = [
  { path: '', component: ListComponent },
  { path: 'create', component: CreateComponent },
  { path: 'transfer', component: TransferComponent },
];

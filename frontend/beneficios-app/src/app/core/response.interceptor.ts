import { HttpInterceptorFn } from '@angular/common/http';
import { map } from 'rxjs/operators';

export const responseInterceptor: HttpInterceptorFn = (req, next) => {
  return next(req).pipe(
    map((event: any) => {
      if (event && event.body && event.body.success !== undefined) {
        if (!event.body.success) {
          throw new Error(event.body.message || 'Erro na API');
        }

        return event.clone({
          body: event.body.data,
        });
      }

      return event;
    }),
  );
};

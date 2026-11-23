import { HttpErrorResponse, HttpInterceptorFn } from '@angular/common/http'; import { catchError, throwError } from 'rxjs';
export const errorInterceptor:HttpInterceptorFn=(req,next)=>next(req).pipe(catchError((error:HttpErrorResponse)=>throwError(()=>({status:error.status,message:error.error?.message??'No se pudo conectar con el servidor',error:error.error?.error??'Error'}))));

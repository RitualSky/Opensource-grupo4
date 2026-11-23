export interface CatalogOption { id:number|string; nombre:string }
export interface Catalogos { docentes:CatalogOption[]; cursos:CatalogOption[]; sedes:CatalogOption[]; ciclos:CatalogOption[] }
export interface CargaAcademica { id:number; cicloAcademico:string; docenteId:number; docente:string; cursoId:number; curso:string; seccion:string; sedeId:number; sede:string; diaSemana:string; horaInicio:string; horaFin:string; estado:'ACTIVA'|'ANULADA'; horasAcumuladas:number }
export interface CargaAcademicaRequest { cicloAcademico:string; docenteId:number; cursoId:number; seccion:string; sedeId:number; diaSemana:string; horaInicio:string; horaFin:string }

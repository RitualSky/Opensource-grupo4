package pe.edu.grupo4.carga.dto;
import pe.edu.grupo4.carga.entity.CargaAcademica.EstadoCarga; import java.time.*;
public record CargaAcademicaResponse(Long id,String cicloAcademico,Long docenteId,String docente,Long cursoId,String curso,String seccion,Long sedeId,String sede,DayOfWeek diaSemana,LocalTime horaInicio,LocalTime horaFin,EstadoCarga estado,double horasAcumuladas) {}

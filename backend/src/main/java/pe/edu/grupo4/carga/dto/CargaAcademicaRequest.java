package pe.edu.grupo4.carga.dto;
import jakarta.validation.constraints.*; import java.time.*;
public record CargaAcademicaRequest(@NotBlank @Size(max=20) String cicloAcademico,@NotNull Long docenteId,@NotNull Long cursoId,@NotBlank @Size(max=20) String seccion,@NotNull Long sedeId,@NotNull DayOfWeek diaSemana,@NotNull LocalTime horaInicio,@NotNull LocalTime horaFin) {}

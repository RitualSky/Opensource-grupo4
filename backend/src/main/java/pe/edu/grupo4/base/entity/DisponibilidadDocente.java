package pe.edu.grupo4.base.entity;
import jakarta.persistence.*; import lombok.*; import java.time.*;
@Entity @Table(name="disponibilidades_docente") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DisponibilidadDocente { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(optional=false) @JoinColumn(name="docente_id") private Docente docente; @Enumerated(EnumType.STRING) @Column(name="dia_semana",nullable=false) private DayOfWeek diaSemana; @Column(name="hora_inicio",nullable=false) private LocalTime horaInicio; @Column(name="hora_fin",nullable=false) private LocalTime horaFin; @ManyToOne(optional=false) @JoinColumn(name="sede_id") private Sede sede; }

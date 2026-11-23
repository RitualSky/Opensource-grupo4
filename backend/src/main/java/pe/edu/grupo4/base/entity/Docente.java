package pe.edu.grupo4.base.entity;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="docentes") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Docente { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false) private String nombres; @Column(nullable=false) private String apellidos; @Column(nullable=false) private String especialidad; @Column(name="modalidad_tiempo_parcial",nullable=false) private boolean modalidadTiempoParcial; @Column(name="max_horas_semanales",nullable=false) private int maxHorasSemanales; public String getNombreCompleto(){return nombres+" "+apellidos;} }

package pe.edu.grupo4.base.entity;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="cursos") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Curso { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false,unique=true) private String codigo; @Column(nullable=false) private String nombre; @Column(name="especialidad_requerida",nullable=false) private String especialidadRequerida; @Column(name="horas_semanales",nullable=false) private int horasSemanales; }

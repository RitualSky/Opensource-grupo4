package pe.edu.grupo4.base.entity;
import jakarta.persistence.*; import lombok.*;
@Entity @Table(name="sedes") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Sede { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false) private String nombre; @Column(nullable=false) private String distrito; }

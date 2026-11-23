package pe.edu.grupo4.carga.repository;
import pe.edu.grupo4.carga.entity.CargaAcademica; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface CargaAcademicaRepository extends JpaRepository<CargaAcademica,Long> { List<CargaAcademica> findByEstado(CargaAcademica.EstadoCarga estado); List<CargaAcademica> findByDocenteIdAndEstado(Long docenteId,CargaAcademica.EstadoCarga estado); }

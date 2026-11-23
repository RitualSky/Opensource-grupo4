package pe.edu.grupo4.carga.service;
import pe.edu.grupo4.carga.dto.*; import java.util.*;
public interface CargaAcademicaService { CargaAcademicaResponse crear(CargaAcademicaRequest request); CargaAcademicaResponse actualizar(Long id,CargaAcademicaRequest request); CargaAcademicaResponse obtener(Long id); List<CargaAcademicaResponse> listar(String ciclo,Long sedeId,Long docenteId); void anular(Long id); }

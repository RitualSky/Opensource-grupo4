package pe.edu.grupo4.carga.mapper;
import pe.edu.grupo4.base.entity.*; import pe.edu.grupo4.carga.dto.*; import pe.edu.grupo4.carga.entity.CargaAcademica;
public final class CargaAcademicaMapper { private CargaAcademicaMapper(){}
 public static CargaAcademica toEntity(CargaAcademicaRequest r,Docente d,Curso c,Sede s){CargaAcademica a=new CargaAcademica();a.setCicloAcademico(r.cicloAcademico().trim());a.setDocente(d);a.setCurso(c);a.setSede(s);a.setSeccion(r.seccion().trim());a.setDiaSemana(r.diaSemana());a.setHoraInicio(r.horaInicio());a.setHoraFin(r.horaFin());a.setEstado(CargaAcademica.EstadoCarga.ACTIVA);return a;}
 public static CargaAcademicaResponse toResponse(CargaAcademica c,double horas){return new CargaAcademicaResponse(c.getId(),c.getCicloAcademico(),c.getDocente().getId(),c.getDocente().getNombreCompleto(),c.getCurso().getId(),c.getCurso().getNombre(),c.getSeccion(),c.getSede().getId(),c.getSede().getNombre(),c.getDiaSemana(),c.getHoraInicio(),c.getHoraFin(),c.getEstado(),horas);}
}

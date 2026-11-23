package pe.edu.grupo4.shared.controller;
import lombok.RequiredArgsConstructor; import org.springframework.web.bind.annotation.*; import pe.edu.grupo4.base.repository.*; import java.util.*;
@RestController @RequestMapping("/api/v1/catalogos") @RequiredArgsConstructor public class CatalogoController {private final DocenteRepository docentes;private final CursoRepository cursos;private final SedeRepository sedes;
 @GetMapping public Map<String,Object> listar(){return Map.of("docentes",docentes.findAll().stream().map(d->Map.of("id",d.getId(),"nombre",d.getNombreCompleto())).toList(),"cursos",cursos.findAll().stream().map(c->Map.of("id",c.getId(),"nombre",c.getNombre())).toList(),"sedes",sedes.findAll().stream().map(s->Map.of("id",s.getId(),"nombre",s.getNombre())).toList(),"ciclos",List.of(Map.of("id","2026-2","nombre","2026-2")));}
}

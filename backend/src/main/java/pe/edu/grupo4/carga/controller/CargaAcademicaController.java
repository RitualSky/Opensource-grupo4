package pe.edu.grupo4.carga.controller;
import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import pe.edu.grupo4.carga.dto.*; import pe.edu.grupo4.carga.service.CargaAcademicaService; import java.util.*;
@RestController @RequestMapping("/api/v1/cargas-academicas") @RequiredArgsConstructor public class CargaAcademicaController {private final CargaAcademicaService service;
 @GetMapping public List<CargaAcademicaResponse> listar(@RequestParam(required=false)String ciclo,@RequestParam(required=false)Long sedeId,@RequestParam(required=false)Long docenteId){return service.listar(ciclo,sedeId,docenteId);}
 @GetMapping("/{id}") public CargaAcademicaResponse obtener(@PathVariable Long id){return service.obtener(id);}
 @PostMapping public ResponseEntity<CargaAcademicaResponse> crear(@Valid @RequestBody CargaAcademicaRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(r));}
 @PutMapping("/{id}") public CargaAcademicaResponse actualizar(@PathVariable Long id,@Valid @RequestBody CargaAcademicaRequest r){return service.actualizar(id,r);}
 @DeleteMapping("/{id}") public ResponseEntity<Void> anular(@PathVariable Long id){service.anular(id);return ResponseEntity.noContent().build();}
}

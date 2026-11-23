package pe.edu.grupo4.shared.exception;
import jakarta.servlet.http.HttpServletRequest; import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.time.Instant; import java.util.*;
@RestControllerAdvice public class GlobalExceptionHandler {
 @ExceptionHandler(ConflictoNegocioException.class) ResponseEntity<Map<String,Object>> conflict(ConflictoNegocioException e,HttpServletRequest r){return response(HttpStatus.CONFLICT,e.getMessage(),r);}
 @ExceptionHandler(RecursoNoEncontradoException.class) ResponseEntity<Map<String,Object>> missing(RecursoNoEncontradoException e,HttpServletRequest r){return response(HttpStatus.NOT_FOUND,e.getMessage(),r);}
 @ExceptionHandler({IllegalArgumentException.class,MethodArgumentNotValidException.class}) ResponseEntity<Map<String,Object>> bad(Exception e,HttpServletRequest r){String msg=e instanceof MethodArgumentNotValidException m?m.getBindingResult().getFieldErrors().stream().map(x->x.getField()+": "+x.getDefaultMessage()).findFirst().orElse("Solicitud inválida"):e.getMessage();return response(HttpStatus.BAD_REQUEST,msg,r);}
 @ExceptionHandler(Exception.class) ResponseEntity<Map<String,Object>> unexpected(Exception e,HttpServletRequest r){return response(HttpStatus.INTERNAL_SERVER_ERROR,"Error interno del servidor",r);}
 private ResponseEntity<Map<String,Object>> response(HttpStatus status,String message,HttpServletRequest request){Map<String,Object> body=new LinkedHashMap<>();body.put("timestamp",Instant.now());body.put("status",status.value());body.put("error",status.getReasonPhrase());body.put("message",message);body.put("path",request.getRequestURI());return ResponseEntity.status(status).body(body);}
}

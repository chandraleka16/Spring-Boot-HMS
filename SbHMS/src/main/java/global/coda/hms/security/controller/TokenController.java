package global.coda.hms.security.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
 
import javax.servlet.ServletException;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hms.security.model.JwtRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
 

@RestController
public class TokenController {
 
    //@PostMapping("/token")
//    public ResponseEntity<String> getToken(@RequestBody JwtRequest request) throws ServletException {
//
// 
//       // return new ResponseEntity<String>(jwttoken, HttpStatus.OK);
//    }
}
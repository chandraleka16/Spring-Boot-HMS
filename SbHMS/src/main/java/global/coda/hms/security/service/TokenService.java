package global.coda.hms.security.service;

import org.springframework.stereotype.Service;

import global.coda.hms.exception.SystemException;
import global.coda.hms.security.mapper.TokenMapper;
import global.coda.hms.security.model.JwtRequest;
import global.coda.hms.security.model.JwtResponse;

@Service
public class TokenService {
  
  
  public TokenMapper mapper;
  public TokenService(TokenMapper mapper) {
    this.mapper=mapper;
  }
  
//  public JwtResponse authenticate(JwtRequest request) {
//    int result=mapper.authenticate(request);
//    JwtResponse response=null;
//    if(result!=1) {
//      throw new SystemException("Invalid User!");
//    }
//    else {
//      
//    }
//  }

}

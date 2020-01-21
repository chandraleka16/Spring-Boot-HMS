package global.coda.hms.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import global.coda.hms.security.model.JwtRequest;

@Mapper
public interface TokenMapper {
  @Select({"select count(*) from t_user where user_name=#{userName} and user_password=#{userPassword"})
  int authenticate(JwtRequest request);

}

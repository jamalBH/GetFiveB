package service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.E_hotel.metier.CompteMetier;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;





public class TokenManager {
	
	@Autowired
	CompteMetier comptemetier ;
	
	
	
	
	public String createToken(String username , String pass ,Integer id_hotel){
		
		
		JwtBuilder jws = Jwts.builder()
				  .claim("id_hotel", id_hotel)
				  .claim("username", username)
				  .claim("pass", pass)
				  .signWith(
				    SignatureAlgorithm.HS256,
				    TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
				  )
				  ;
			
		return jws.compact();			}
	
	
	
	
	
	public boolean checkToken(HttpServletRequest request){
		

		
		
		if(comptemetier.validation(getUsername(request),getPass(request))) {return true  ;}
		
		return false ;
	}
	
	
	
	
	
	public String getUsername(HttpServletRequest request){
		
		
  String username ;
		
		try{
			username = Jwts.parser().setSigningKey("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
				.parseClaimsJws(request.getHeader("Authorization"))
				.getBody().get("username", String.class);
		}
	
		
		catch(Exception e){
			
			username=null ;
			
		}
			
				 return username ;	
		}
	 
	
	public String getPass(HttpServletRequest request){
		
		String pass ;
		
		try{
			pass = Jwts.parser().setSigningKey("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
				.parseClaimsJws(request.getHeader("Authorization"))
				.getBody().get("pass", String.class);
		}
	
		
		catch(Exception e){
			
			pass=null ;
			
		}
			
				 return pass ;	
		}
		
	

	
	public Integer getIdHotel(HttpServletRequest request){
		
		Integer id_hotel ;
		
	try{	 id_hotel	= Jwts.parser().setSigningKey("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
		.parseClaimsJws(request.getHeader("Authorization"))
		.getBody().get("id_hotel", Integer.class); }
	
	catch(Exception e){
		
		id_hotel=null ;
		
	}
		
			 return id_hotel ;	
	}
	
	
}

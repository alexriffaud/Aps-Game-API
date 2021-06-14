package com.apside.apsgame.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apside.apsgame.model.User;
import com.apside.apsgame.repository.UserRepository;
import com.apside.apsgame.util.JwtUtil;

@RestController
@RequestMapping("/api/v1/apsgame")
public class LoginController 
{
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
    @GetMapping("/")
    public String welcome() {
        return "Welcome to javatechie !!";
    }
	
	@PostMapping("/login")
	public String generateToken(@RequestBody User user) throws Exception
	{
		try 
		{
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword())
			);
			user = userRepository.findByLogin(user.getLogin());
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			throw new Exception("Login ou mot de passe incorrect");
		}
		return jwtUtil.generateToken(user.getLogin()) +";"+user.getId()+";"+user.getFirstname()+";"+user.getMail()+";"+user.getBirthdate();

	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) throws Exception
	{
		try {
				String login = user.getLogin();
				String mail = user.getMail();
				String firstname = user.getFirstname();
				String password = user.getPassword();
				LocalDateTime birthDate = user.getBirthdate();

				userRepository.insertUser(mail, firstname, login, password, birthDate); 

				return new ResponseEntity<>("ok", HttpStatus.CREATED);

		} catch (Exception exc) {
			return new ResponseEntity<>("nok", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/checklogin")
	public ResponseEntity<String> checkLogin(@RequestBody User user) throws Exception
	{
		try {

			if(!userRepository.findByLogin(user.getLogin()).getLogin().isEmpty())
			{
				return new ResponseEntity<>("nok", HttpStatus.FOUND);
			}
			else
			{
				return new ResponseEntity<>("ok", HttpStatus.OK);
			}
			
		} catch (Exception exc) {
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}
	}
	
	@PutMapping("/updateAccount")
	public ResponseEntity<String> updateAccount(@RequestBody User user) throws Exception
	{
		try {

			if(!userRepository.findById(user.getId()).get().getLogin().isEmpty())
			{
				Long id = user.getId();
				String login = user.getLogin();
				String mail = user.getMail();
				String firstname = user.getFirstname();
				String password = user.getPassword();
				
				userRepository.updateUser(id, mail, firstname, login, password); 
				return new ResponseEntity<>("ok", HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>("nok", HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception exc) {
			return new ResponseEntity<>("nok", HttpStatus.NOT_FOUND);
		}
	}
}

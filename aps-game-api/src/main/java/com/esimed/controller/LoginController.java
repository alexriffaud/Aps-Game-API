package com.esimed.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esimed.model.User;
import com.esimed.repository.UserRepository;
import com.esimed.util.JwtUtil;

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
		return jwtUtil.generateToken(user.getLogin()) +";"+user.getId();

	}
}
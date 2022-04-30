package com.example.quizback.RestController.UserCurdApi;

import com.example.quizback.ConfigSecurity.JwtUtil;
import com.example.quizback.model.jwtDTO.jwtRequest;
import com.example.quizback.model.jwtDTO.jwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthAPI {


    @Autowired
    private UserDetailsService userService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    public void Authentication(String username, String password){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }
        catch (BadCredentialsException e){ System.out.println(e);}
        catch (DisabledException e){System.out.println(e);}
    }

    @PostMapping("/token")

    public ResponseEntity<?> getToken(@RequestBody jwtRequest jwtRequest){
        try{
            Authentication(jwtRequest.getUsername(),jwtRequest.getPassword());
            UserDetails userDetails = this.userService.loadUserByUsername(jwtRequest.getUsername());
            String s = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new jwtResponse(s));
        }
        catch (Exception e){System.out.println(e);
        return new ResponseEntity<String>(e.getMessage().toString(), HttpStatus.I_AM_A_TEAPOT);}
    }

    @GetMapping("/currentUser")
    public ResponseEntity<?> getcurrentUser(Principal principal){

        return ResponseEntity.ok(userService.loadUserByUsername(principal.getName()));
    }
}

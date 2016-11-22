package com.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.model.Authentication;
import com.model.Authorization;
import com.model.UserProfile;
import com.service.AuthenticationService;
import com.service.AuthorizationService;

@Controller
public class LoginController {
	 @Autowired
	 ServletContext context; 	
	@Autowired
	AuthenticationService authenService;
	@Autowired
	AuthorizationService roleService;
	public LoginController(){}
	public LoginController(AuthenticationService authenService){
		
		this.authenService=authenService;
				
	}
	public LoginController(AuthorizationService roleService){
		this.roleService=roleService;
	}
	@RequestMapping("/login")
	public String showLoginPage(){
		return "loginPage";
	}
	@RequestMapping("/signUp")
	public ModelAndView showSignUp(){
		
		return new ModelAndView("signUpPage","user",new Authentication());
		
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.POST)
	public ModelAndView  addUser(@Valid @ModelAttribute("user")Authentication user,BindingResult result){
		if (result.hasErrors()) {
	           return new ModelAndView("signUpPage");
	    }
		else{
		
		System.out.println("Adding a user");
		//System.out.println(user.getUserName());
		//System.out.println(user.getPassword());
		authenService.addUser(user);
		Authorization role=new Authorization();
		role.setUserName(user.getUserName());
		roleService.addRole(role);	
		//-----------multipart--------------------------------------------------
		String filename = null;
		System.out.println(context);			
		String path = context.getRealPath("/resources/" + user.getUserName() + ".jpg");
		System.out.println("Path = " + path);
		System.out.println("File name = " + user.getProfilePhoto().getOriginalFilename());
		File f = new File(path);
		if (!user.getProfilePhoto().isEmpty()) {
			try {
				
					filename=user.getProfilePhoto().getOriginalFilename(); 
					byte[]bytes=user.getProfilePhoto().getBytes();
					BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
					bs.write(bytes);
					bs.close();
					System.out.println("Image uploaded");
				
					//System.out.println("Data Inserted"+(res++));
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		} 
		
			return new ModelAndView("redirect:/index?profileStatus=true");
		}	
		
		
		
		}
	@RequestMapping(value = { "/MyProfile" })
	public String profilePage(@RequestParam("username")String username,Model model) {			
		Authentication profile=authenService.getProfile(username);
			model.addAttribute("profile", profile);
			  
		return "MyProfile";
	}
	
	@RequestMapping(value = {"/updateProfile"},method=RequestMethod.POST)
	public String updateProfilePage(@ModelAttribute("profile")Authentication profile,BindingResult result) {
		if(!result.hasErrors()){
			System.out.println("updating profile in controller:"+profile.getUserName());
			authenService.updateProfile(profile,profile.getUserName());				
			
		}			
		return "MyProfile";
		
	}
} 
		
	


/*package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.model.Authentication;
import com.model.Authorization;
import com.model.UserProfile;
import com.service.UserProfileService;
@Controller
public class UserProfileController {
	
	   @Autowired
	   ServletContext context; 
	
	public UserProfileController(){		
		
	}
	@Autowired
	UserProfileService service;
	public UserProfileController(UserProfileService service){
		this.service=service;	
	}
	@RequestMapping("/createProfile")
	public ModelAndView showSignUp(){
		
		return new ModelAndView("createProfile","profile",new UserProfile());
	}
	
	@RequestMapping(value="/addProfile",method=RequestMethod.POST)
	public ModelAndView  addUser(@ModelAttribute("profile")@Valid UserProfile profile,BindingResult result){
		//int res = 0;
		if(result.hasErrors()){
		System.out.println(result.getAllErrors());	
				return new ModelAndView("redirect:/index");
		}
		else{
			System.out.println("adding profile");
		service.addProfile(profile);
		String filename = null;
		System.out.println(context);	
		
		String path = context.getRealPath("/resources/" + profile.getProfileId() + ".jpg");
		System.out.println("Path = " + path);
		System.out.println("File name = " + profile.getProfilePhoto().getOriginalFilename());
		File f = new File(path);
		if (!profile.getProfilePhoto().isEmpty()) {
			try {
				
					filename=profile.getProfilePhoto().getOriginalFilename(); 
					byte[]bytes=profile.getProfilePhoto().getBytes();
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

	//------------------My profile---------------------------------------------------
	@RequestMapping(value = { "/MyProfile" })
	public String profilePage(@RequestParam("profileId")String profileId,Model model) {
			UserProfile profile=service.getProfile(profileId);
			model.addAttribute("profile", profile);
			
		return "MyProfile";
	}
} */



package com.github.oimdb.oimdbspike.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.ws.rs.POST;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.oimdb.oimdbspike.domain.Meme;
import com.github.oimdb.oimdbspike.domain.MemeMedium;
import com.github.oimdb.oimdbspike.repositories.MemeRepository;

@Controller
public class FooController {
  @Autowired
  MemeRepository memeRepository;
  
	
  @RequestMapping("/")
  public String showCount(Model model) throws MalformedURLException {
    //let’s pass some variables to the view script
    
    Meme randomMeme = new Meme(new Date().toString(),  MemeMedium.VIDEO, new URL("http://youtube.com"), new DateTime() );
	memeRepository.save(randomMeme);
    model.addAttribute("count", memeRepository.count());
    
    model.addAttribute("memeNames",memeRepository.getAllMemeNames());
    return "countPage"; // renders /WEB-INF/views/hello.jsp
  }
  
  @RequestMapping(value="/input", method=RequestMethod.POST)
  public String inputNewStuff(Model model) throws MalformedURLException {
    return "input"; // renders /WEB-INF/views/hello.jsp
  }
  
  @RequestMapping("/bootstrap")
  public String startPoint(Model model){
	  return "index";
  }
 
}
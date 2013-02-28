package com.github.oimdb.oimdbspike.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.oimdb.oimdbspike.domain.Meme;
import com.github.oimdb.oimdbspike.domain.MemeMedium;
import com.github.oimdb.oimdbspike.repositories.MemeRepository;

@Controller
public class MainController {
  @Autowired
  MemeRepository memeRepository;
  
	
  @RequestMapping("/count")
  public String showCount(Model model) throws MalformedURLException {
    //lets pass some variables to the view script
    model.addAttribute("count", memeRepository.count());
    
    model.addAttribute("memes",memeRepository.getAllMemes());
    return "countPage"; // renders /WEB-INF/views/hello.jsp
  }
  
  @RequestMapping(value="/inputpost", method=RequestMethod.POST)
  public String inputPost ( @RequestParam("memename") String memename,
                            @RequestParam("memeurl") URL url, Model model) throws MalformedURLException {
	  Meme newMeme = new Meme(memename,  MemeMedium.VIDEO, url, new DateTime() );
	  memeRepository.save(newMeme);
	  return "redirect:/"; // renders /WEB-INF/views/hello.jsp
  }
  
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String inputGet(Model model) throws MalformedURLException {
      model.addAttribute("count", memeRepository.count());

      model.addAttribute("memes",memeRepository.getAllMemes());
      return "input"; // renders /WEB-INF/views/hello.jsp
  }
  
  @RequestMapping("/bootstrap")
  public String startPoint(Model model){
	  return "index";
  }
 
}
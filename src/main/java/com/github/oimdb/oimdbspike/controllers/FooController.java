package com.github.oimdb.oimdbspike.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.oimdb.oimdbspike.domain.Meme;
import com.github.oimdb.oimdbspike.domain.MemeMedium;
import com.github.oimdb.oimdbspike.repositories.MemeRepository;

@Controller
public class FooController {
  @Autowired
  MemeRepository memeRepository;
  
	
  @RequestMapping("/")
  public String showCount(Model model) throws MalformedURLException {
    //lets pass some variables to the view script
    
    Meme randomMeme = new Meme("meme" + (new Date()).getTime(),  MemeMedium.VIDEO, new URL("http://youtube.com/" + (new Date()).toString()), new DateTime() );
//	memeRepository.save(randomMeme);
    model.addAttribute("count", memeRepository.count());
    
    model.addAttribute("memeNames",memeRepository.getAllMemes());
    return "countPage"; // renders /WEB-INF/views/hello.jsp
  }
  
  @RequestMapping(value="/inputpost", method=RequestMethod.POST)
  public String inputPost ( @RequestParam("memename") String memename, Model model) throws MalformedURLException {
	  Meme newMeme = new Meme(memename,  MemeMedium.VIDEO, new URL("https://google.com/"+memename), new DateTime() );
	  memeRepository.save(newMeme);
	  return "input"; // renders /WEB-INF/views/hello.jsp
  }
  
  @RequestMapping(value="/input", method=RequestMethod.GET)
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
package com.github.oimdb.oimdbspike.controllers;

import java.net.MalformedURLException;
import java.util.Date;

import com.github.oimdb.oimdbspike.domain.Observation;
import com.github.oimdb.oimdbspike.domain.ObservationType;
import com.github.oimdb.oimdbspike.repositories.ObservationRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.joda.time.format.DateTimeFormat;

@Controller
public class MainController {
  @Autowired
  ObservationRepository observationRepository;
  
	
  @RequestMapping("/count")
  public String showCount(Model model) throws MalformedURLException {
    //lets pass some variables to the view script
    model.addAttribute("count", observationRepository.count());
    
    model.addAttribute("observations", observationRepository.getAllObservations());
    return "countPage"; // renders /WEB-INF/views/hello.jsp
  }
  
  @RequestMapping(value="/addobservation", method=RequestMethod.POST)
  public String inputPost ( @RequestParam("lat") Double lat,
                            @RequestParam("lng") Double lng,
                            @RequestParam("altitude") Double altitude,
                            @RequestParam("direction") Double direction,
                            @RequestParam("angle") Double angle,
                            @RequestParam("date") String date, Model model) throws MalformedURLException {
      DateTime dateTime = DateTime.parse(date, DateTimeFormat.forPattern("dd/MM/yyyy hh:mm:ss"));
	  Observation observation = new Observation(lat, lng, ObservationType.HIRES_CAMERA , altitude, direction, angle);
	  observationRepository.save(observation);
	  return "redirect:/"; // renders /WEB-INF/views/hello.jsp
  }
  
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String inputGet(Model model) throws MalformedURLException {
      model.addAttribute("count", observationRepository.count());

      model.addAttribute("observations", observationRepository.getAllObservations());
      return "input"; // renders /WEB-INF/views/hello.jsp
  }
  
  @RequestMapping("/bootstrap")
  public String startPoint(Model model){
	  return "index";
  }
 
}
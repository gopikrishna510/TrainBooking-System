package com.booking.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.app.dto.Train;
import com.booking.app.service.TrainService;

@Controller
public class TrainController 
{ 
	@Autowired
	private TrainService trainService;

	//this method will be used to display save page for train
	@RequestMapping("/saveTrainPage")
	public String displaySaveTrainPage()
	{
		return "saveTrainPage";
	}
	@RequestMapping(value="/saveTrain" ,method=RequestMethod.POST)
	public String saveTrain( @Valid Train train ,BindingResult result, Model model) 
	{
		System.out.println(train);

		if(result.hasErrors())
		{
			List<FieldError> errors =result.getFieldErrors();
			for(FieldError fieldError : errors)
			{
				//hardcoded 
				//model.addAttribute(fieldError.getField(),"this filed has some error");
				//using hibernate validotor
				model.addAttribute(fieldError.getField(),fieldError.getDefaultMessage());
			}
			//model.addAttribute("msg", "Wrong data entered");
			return "saveTrainPage";
		}

		int pk=trainService.saveTrain(train);

		if(pk>0)
		{
			model.addAttribute("msg", "train saved with pk ->"+pk);
			return "saveTrainPage";
		}
		else{
			model.addAttribute("msg", "train not saved  ");
		}

		return "saveTrainPage";
	}

	//redirect to search page
	@RequestMapping("/searchTrainPage")
	public String searchTrainPage()
	{
		return "searchTrainPage";
	}
	
	
	@RequestMapping("/admin/searchTrainPage")
	public String adminSearchTrainPage(Model model) {
		List<Train> trains = trainService.searchTrainByDestination("", "");

		if (trains == null || trains.size() == 0) {
			model.addAttribute("msg", "No trains available from current locations");
		} else {
			model.addAttribute("trains", trains);
		}
		return "adminAllTrainPage";
	}
	
	
	@RequestMapping("/user/searchTrainPage")
	public String userSearchTrainPage(Model model) {
		List<Train> trains = trainService.searchTrainByDestination("", "");

		if (trains == null || trains.size() == 0) {
			model.addAttribute("msg", "No trains available from current locations");
		} else {
			model.addAttribute("trains", trains);
		}
		return "userAllTrainsPage";
	}


	@RequestMapping("/searchTrainByDestination")
	public String searchTrain(@RequestParam String from 
			,@RequestParam String to, Model model)
	{
		System.out.println("From -->"+from+" To -->"+to);


		//logic to find train from DB

		//another ways using Lambda Expressions 
		//trainService.searchTrainByDestination(from, to).forEach(System.out::println);

		//getting data from DB
		List<Train> trains = trainService.searchTrainByDestination(from, to);
		
		//only two cases the data is not there..
		if(trains == null || trains.size() == 0)
		{
			//System.out.println("No trains Available");
			model.addAttribute("msg", "No trains avialable from current Location");
		}
		else
		{
			model.addAttribute("trains", trains);
		}
		
//		for(Train train : trains)
//		{
//			System.out.println(train);
//		}


		//return it to the same page 
		//so that he can search more options
		return "searchTrainPage";
	} 
	
	
	@RequestMapping("/deleteTrainPage/{id}")
	public String deleteTrain(@PathVariable int id, Model model) {

		System.out.println(id);
		trainService.deleteTrainById(id);
		List<Train> trains = trainService.searchTrainByDestination("", "");

		if (trains == null || trains.size() == 0) {
			model.addAttribute("msg", "No trains available from current locations");
		} else {
			model.addAttribute("trains", trains);
		}
		return "adminAllTrainPage";

	}

	@RequestMapping("/updateTrainPage/{id}")
	public String UpdateTrainPage(@PathVariable int id, Model model) {
		Train train = trainService.findTrainById(id);
		model.addAttribute("train", train);
		return "udapteTrainPage";
	}

	@RequestMapping("/updateTrain")
	public String updateTrain(Train train, Model model) {

		System.out.println(train);
		
		trainService.updateTrain(train);
		
		
		
		
		List<Train> trains = trainService.searchTrainByDestination("", "");

		if (trains == null || trains.size() == 0) {
			model.addAttribute("msg", "No trains available from current locations");
		} else {
			model.addAttribute("trains", trains);
		}
		return "adminAllTrainPage";

	}

}

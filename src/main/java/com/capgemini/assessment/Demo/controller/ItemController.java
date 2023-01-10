package com.capgemini.assessment.Demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.capgemini.assessment.Demo.MapStruct.MapStructMapper;
import com.capgemini.assessment.Demo.dto.ItemDto;
import com.capgemini.assessment.Demo.service.ItemServiceImpl;
import com.capgemini.assessment.Demo.util.ItemConstants;


@RestController
@RequestMapping("/items")
public class ItemController {
    
	@Autowired
    private ItemServiceImpl service;
	
	@Autowired
	private MapStructMapper mapStruct;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(ItemController.class);

    @RequestMapping(value=ItemConstants.GET)
    public List<ItemDto> getAllItems(){
    	LOGGER.info("inside class !!! ItemController, method!!!: getAllItems");
        return service.getAllItems();
    }

    @GetMapping(value=ItemConstants.GETBYID)
    public ItemDto getItem(@PathVariable int id){
    	LOGGER.info("inside class !!! ItemController, method!!!: getItem");
        return service.getItem(id);
    }

    @PostMapping(value=ItemConstants.SAVE)
    public String addItem( @RequestBody ItemDto id) {
    	LOGGER.info("inside class !!! ItemController, method!!!: addItem");
    	return service.addItem(id)+"New Details added successfully";
    }
    
    @DeleteMapping(value=ItemConstants.DELETE)
    public String deleteItem(@PathVariable int id){
    	LOGGER.info("inside class !!! ItemController, method!!!: deleteItem");
    		return service.deleteItem(id);
        
    }
    @GetMapping(value=ItemConstants.HEALTH)
    public String HealthCheck() {
    	LOGGER.info("Health check");
    	return "Status : up ";
    }
}
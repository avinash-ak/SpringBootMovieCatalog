package com.example.three;
import java.util.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class Movicatologue {
	
	@RequestMapping("/{userId}")
	public List<CatalogItem>getCatalog(@PathVariable("userId")String userId){
		
		return Collections.singletonList(new CatalogItem("BBT","Comedy",8));
	}
}

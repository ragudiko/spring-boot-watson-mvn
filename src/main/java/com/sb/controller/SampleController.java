package com.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.discovery.v1.Discovery;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryOptions;
import com.ibm.watson.developer_cloud.discovery.v1.model.QueryResponse;

@Controller
public class SampleController {
	
    @Value("${watson.discovery.environment_id}")
    private String environment_id;
    @Value("${watson.discovery.collection_id}")
    private String collection_id;

	@Autowired
	protected Discovery discovery;
	
	@RequestMapping(value = "/")
	@ResponseBody
	public String discover() {
		return "Welcome to Spring Boot - Watson - Postgres demo ** ---> running on IBM Cloud";
	}
	
  
    @GetMapping(value = "/discover")
    @ResponseBody
    public String discover(@RequestParam("info") String search) {
    	try {
		System.out.println("search");
		//QueryOptions queryOptions = new QueryOptions.Builder().build();
		QueryOptions queryOptions = new QueryOptions.Builder(environment_id, collection_id)
				.naturalLanguageQuery("transport injured person")
				.passages(Boolean.valueOf(true))
				.build();

		//System.out.println("passages"+ passages );
		System.out.println("nlq"+ queryOptions.naturalLanguageQuery() + queryOptions.passages());
		QueryResponse queryResponse = discovery.query(queryOptions).execute();
		System.out.println(queryResponse.getPassages());
		return queryResponse.toString();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return "error while quering discovery";
		
	}
    
}

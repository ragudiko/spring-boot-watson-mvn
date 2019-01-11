//package com.sb.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.sb.dao.BloggerDao;
//import com.sb.model.Blogger;
//
//@Controller
//@RequestMapping(value = "/blogger")
//public class BloggerController {
//
//	@Autowired
//    private BloggerDao bloggerDao;
//	
//	//@Autowired
//    Blogger blogger = new Blogger();
//	
//	@RequestMapping(value = "/")
//    @ResponseBody
//    public String index() {
//		return "Welcome to Spring Boot - JPA - Hibernate - Postgres demo ---> running on IBM Cloud";
//	}
//
//    @RequestMapping(value = "/delete")
//    @ResponseBody
//    public String delete(long bloggerid) {
//        try {
//
//            blogger.setBloggerid(bloggerid);
//            bloggerDao.delete(blogger);
//        } catch (Exception ex) {
//            return ex.getMessage();
//        }
//        return "Blogger succesfully deleted!";
//    }
//    
//    @RequestMapping("/savebloggers")
//	public String savebloggers(){
//		// save blogger details
//    	bloggerDao.save(new Blogger("Rajesh", "Gudikoti"));
//    	bloggerDao.save(new Blogger("Hemanth", "H G"));
//
//		return "Done with saving bloggers";
//	}
//
//    @RequestMapping(value = "/save")
//    @ResponseBody
//    public String create(String firstName, String lastName) {
//        try {
//            Blogger blogger = new Blogger();
//            blogger.setFirstName(firstName);
//            blogger.setLastName(lastName);
//            bloggerDao.save(blogger);
//        } catch (Exception ex) {
//            return ex.getMessage();
//        }
//        return "Blogger succesfully saved!";
//    }
//    
//    @RequestMapping(value = "/findall")
//    @ResponseBody
//    public List findAll() {
//        try {
//            return bloggerDao.findAll();
//        } catch (Exception ex) {
//        	System.out.println("Error returning blogger list");
//        	ex.printStackTrace();
//            return null;
//        }
//    }
//}

//package com.wipro.obp.keycloakconsent.application.productapp;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class ProductController {
//@Autowired ProductService productService;
//
//   @GetMapping(path = "/products")
//   public String getProducts(Model model){
//       model.addAttribute("products", productService.getProducts());
//       return "products";
//   }
//}
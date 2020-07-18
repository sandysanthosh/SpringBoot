package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.product;
import com.example.demo.repository.productRespository;

@RestController
public class productController {
	
	@Autowired
	private productRespository repo;
	
	@RequestMapping("/product")
	public String getAllProduct(Model model)
	{
		model.addAttribute("products", repo.findAll());
		return "product";
	}
	
	@GetMapping("/findAllUser")
	public List<product> getAllUser() {
		return repo.findAll();
	}

	@PostMapping("/addUser")
	public String addAllUser(@RequestBody product product) {
		repo.save(product);
		return "User id";
	}

	/*
	 * @DeleteMapping("/deleteUser/{id}") public String deleteUser(@PathVariable int
	 * id) { repo.deleteById(id); return "User id"; }
	 */
	@RequestMapping("/create")
	public String create(Model model)
	{
		return "create";
	}
	
	@RequestMapping("/save")
		public String save(@RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Double prodPrice, @RequestParam String prodImage) {
		product product = new product();
		product.setProductName(prodName);
		product.setProductDesc(prodDesc);
		product.setProductPrice(prodPrice);
		product.setProductImage(prodImage);
		repo.save(product);
        return "redirect:/show/" + product.getProductID();
    }

	 @RequestMapping("/show/{id}")
	    public String show(@PathVariable String id, Model model) {
	        model.addAttribute("product", repo.findById(id).get());
	        return "show";
	    }

	    @RequestMapping("/delete")
	    public String delete(@RequestParam String id) {
	        Optional<product> product = repo.findById(id);
	        repo.delete(product.get());

	        return "redirect:/product";
	    }
	    
	    @RequestMapping("/edit/{id}")
	    public String edit(@PathVariable String id, Model model) {
	        model.addAttribute("product", repo.findById(id).get());
	        return "edit";
	    }
	    
	    @RequestMapping("/update")
	    public String update(@RequestParam String id, @RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Double prodPrice, @RequestParam String prodImage) {
	        Optional<product> product = repo.findById(id);
	        product.get().setProductName(prodName);
	        product.get().setProductDesc(prodDesc);
	        product.get().setProductPrice(prodPrice);
	        product.get().setProductImage(prodImage);
	        repo.save(product.get());

	        return "redirect:/show/" + product.get().getProductID();
	    }

}

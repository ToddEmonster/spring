package fr.todd.ecommerce.controller;

import fr.todd.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller des pages concernant les produits
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * Page de liste de tous les produits
     * @param model     Model de la page JSP
     * @return
     */
    @GetMapping(value = { "", "/" })
    public void getProducts(Model model) {
        System.out.println("/products : get all products");
        model.addAttribute("products", productService.getAllProducts());
//        return "products";
    }

    /**
     * Page de liste de détail d'un produit
     * @param model     Model de la page JSP
     * @param id        Id du produit
     * @return
     */
    @GetMapping("/{productId}")
    public String getProductById(Model model, @PathVariable("productId") Long id) {
        System.out.println("/products/id : get product by id (" + id + ")");
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }


}

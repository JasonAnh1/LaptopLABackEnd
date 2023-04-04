package com.JasonAnh.LaptopLABackEnd.controller;

import com.JasonAnh.LaptopLABackEnd.configuration.Translator;
import com.JasonAnh.LaptopLABackEnd.entity.Product;
import com.JasonAnh.LaptopLABackEnd.entity.ProductCategory;
import com.JasonAnh.LaptopLABackEnd.entity.Suppliers;
import com.JasonAnh.LaptopLABackEnd.entity.constants.ProductFilterStatus;
import com.JasonAnh.LaptopLABackEnd.entity.constants.ProductType;
import com.JasonAnh.LaptopLABackEnd.entity.response.BaseResponse;
import com.JasonAnh.LaptopLABackEnd.service.product.ProductService;
import com.JasonAnh.LaptopLABackEnd.service.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
@Transactional
public class ProductController extends BaseController{
    @Autowired
    private ProductService productService;
    @Autowired
    private SupplierService supplierService;
    @GetMapping("v1/product/get")
    public ResponseEntity<?> get(@RequestParam final int page,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Long categoryId) {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
                   productService.getListProduct(page,name,categoryId)));
            //            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"),
//                    productServer.getListProduct(page, false)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
    @GetMapping("v1/product/detail")
    public ResponseEntity<?> getDetailProduct(@RequestParam final long id) {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), productService.getProductById(id)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
    @GetMapping("v1/product/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam final long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss")));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
    @PostMapping("admin/v1/product/add")
    public ResponseEntity<?> add(@Valid @RequestBody final Product request) {
        try {
            if (request == null
                    || request.getTitle() == null
                    || request.getDescription() == null
                    || (request.getImageUrl() == null && request.getMediaId() == null)
                    || request.getPrice() == 0
                    || request.getPriceAfterDiscount() == 0
                    || request.getCategoryId() == 0) {
                throw new Exception(Translator.toLocale("required_fields"));
            }
            if (request.getMediaId() != null && request.getMediaId() == 0) {
                throw new Exception(Translator.toLocale("invalid_request"));
            }
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), productService.addProduct(request)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
    @PostMapping("admin/v1/product/update")
    public ResponseEntity<?> update(@Valid @RequestBody final Product request) {
        try {
            if (request == null
                    || request.getId() == 0
                    || request.getTitle() == null
                    || request.getDescription() == null
                    || (request.getImageUrl() == null && request.getMediaId() == null)
                    || request.getPrice() == 0
                    || request.getPriceAfterDiscount() == 0
                    || request.getCategoryId() == 0) {
                throw new Exception(Translator.toLocale("required_fields"));
            }
            if (request.getMediaId() != null && request.getMediaId() == 0) {
                throw new Exception(Translator.toLocale("invalid_request"));
            }
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), productService.updateProduct(request)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
    @PostMapping("admin/supplier/add")
    public ResponseEntity<?> supplierAdd(@RequestBody Suppliers request) {
        try {
            if (request == null) {
                throw new Exception(Translator.toLocale("required_fields"));
            }
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), supplierService.createSupplier(request)));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
    @GetMapping("/supplier/get")
    public ResponseEntity<?> supplierGet() {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), supplierService.getAllSuppliers()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
 @PostMapping("admin/product_category/add")
 public ResponseEntity<?> productCategory(@RequestBody ProductCategory request) {
     try {
         if (request == null || request.getTitle() == null) {
             throw new Exception(Translator.toLocale("required_fields"));
         }
         return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), productService.addProductCategory(request)));
     } catch (Exception ex) {
         return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
     }
 }

    @GetMapping("/product_category/get")
    public ResponseEntity<?> productCategoryGet() {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), productService.getAllProductCategory()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
    @GetMapping("/location/get")
    public ResponseEntity<?> getLocation() {
        try {
            return ResponseEntity.ok(new BaseResponse(Translator.toLocale("succecss"), productService.getLocation()));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BaseResponse(ex.getMessage(), null));
        }
    }
}

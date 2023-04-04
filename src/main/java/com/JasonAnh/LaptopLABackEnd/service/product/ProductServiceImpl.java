package com.JasonAnh.LaptopLABackEnd.service.product;

import com.JasonAnh.LaptopLABackEnd.configuration.Translator;
import com.JasonAnh.LaptopLABackEnd.entity.*;
import com.JasonAnh.LaptopLABackEnd.entity.constants.ProductStatus;
import com.JasonAnh.LaptopLABackEnd.entity.constants.RoleName;
import com.JasonAnh.LaptopLABackEnd.entity.constants.UploadFileType;
import com.JasonAnh.LaptopLABackEnd.repository.ImageRepository;
import com.JasonAnh.LaptopLABackEnd.repository.product.LocationRepository;
import com.JasonAnh.LaptopLABackEnd.repository.product.ProductCategoryRepository;
import com.JasonAnh.LaptopLABackEnd.repository.product.ProductRepository;
import com.JasonAnh.LaptopLABackEnd.repository.product.ProductRepositoryCustom;
import com.JasonAnh.LaptopLABackEnd.repository.supplier.SuppliersRepository;
import com.JasonAnh.LaptopLABackEnd.service.BaseService;
import com.JasonAnh.LaptopLABackEnd.service.file.FileStorageService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductServiceImpl extends BaseService implements ProductService {
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    SuppliersRepository suppliersRepository;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Override
    public List<Product> getListProduct(int page, String name,Long categoryId) throws Exception {
        return productRepository.getProducts( page, name,categoryId);
    }

    @Override
    public Product getProductById(Long id) throws Exception {
        Product product = productRepository.findById(id).orElseThrow(() -> new Exception("Không tìm thấy sản phẩm"));
        if (!StringUtils.isEmpty(product.getMediaIds())) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Long> mediaIds = objectMapper.readValue(product.getMediaIds(), new TypeReference<List<Long>>() {
            });
            product.setFile(imageRepository.findAllById(mediaIds));}
        return product;
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        Product current = productRepository.findById(id).orElseThrow(()-> new Exception("Cant find"));
        current.setDeleted(true);
    }

    @Override
    public List<Location> getLocation() throws Exception {
        return locationRepository.findAll();
    }

    @Override
    public Product updateProduct(Product request) throws Exception {
        User user = getUser();
        if (user.getRoles().get(0).getName() == RoleName.ROLE_USER) {
            throw new Exception(Translator.toLocale("access_denied"));
        }
        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new Exception(("Không tìm thấy sản phẩm")));
        if (product == null) {
            throw new Exception("không tìm thấy sản phẩm");
        }
        if (request.getFileIds()!= null){
            ObjectMapper objectMapper = new ObjectMapper();
            String data = objectMapper.writeValueAsString(request.getFileIds());
            product.setMediaIds(data);
            product.setFileIds(request.getFileIds());
        }

        ProductCategory c =  productCategoryRepository.findById(request.getCategoryId()).orElseThrow(()-> new Exception("không tìm thấy category"));
        product.setCategoryId(request.getCategoryId());
        product.setCategory(c);
        product.setDescription(request.getDescription());
        product.setTitle(request.getTitle());
        product.setPrice(request.getPrice());
        product.setCategoryId(request.getCategoryId());
        product.setPriceAfterDiscount(request.getPriceAfterDiscount());
        product.setRating(request.getRating());
        product.setRemain(request.getRemain());
        product.setImageUrl(request.getImageUrl());
        product.setMediaId(request.getMediaId());
        product.setSold(request.getSold());
        product.setSupplier_id(request.getSupplier_id());
        if (request.getMediaId() == null && !StringUtils.isEmpty(request.getImageUrl())) {
            UploadFile uploadFile = fileStorageService.getMedia(UploadFileType.IMAGE, request.getImageUrl(), request.getImageUrl());
            product.setMediaId(uploadFile.getId());
            product.setMedia(uploadFile);
        }
        if (request.getMediaId() != null) {
            UploadFile uploadFile = imageRepository.findById(request.getMediaId()).orElseThrow(() -> new Exception("Không tìm thấy hình ảnh"));
            product.setImageUrl(uploadFile.getThumbUrl());
        }
        System.out.println(product.getMediaIds());
        return productRepository.save(product);
    }

    @Override
    public Product addProduct(Product product) throws Exception {
        User user = getUser();
        if (user.getRoles().get(0).getName() == RoleName.ROLE_USER) {
            throw new Exception(Translator.toLocale("access_denied"));
        }
        if (product.getFileIds() != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            String data = objectMapper.writeValueAsString(product.getFileIds());
            product.setMediaIds(data);
        }
        ProductCategory p = productCategoryRepository.findById(product.getCategoryId()).orElseThrow(() -> new Exception("Product category not found"));
        Suppliers s = suppliersRepository.findById(product.getSupplier_id()).orElseThrow(() -> new Exception("Supplier not found"));
        product.setCategoryId(product.getCategoryId());
        product.setSupplier_id(product.getSupplier_id());
        product.setSupplier(s);
        product.setCategory(p);
        product.setStatus(ProductStatus.ON_SALE);
        if (product.getMediaId() == null && !StringUtils.isEmpty(product.getImageUrl())) {
            UploadFile uploadFile = fileStorageService.getMedia(UploadFileType.IMAGE, product.getImageUrl(), product.getImageUrl());
            product.setMediaId(uploadFile.getId());
            product.setMedia(uploadFile);
        }
        if (product.getMediaId() != null) {
            UploadFile uploadFile = imageRepository.findById(product.getMediaId()).orElseThrow(() -> new Exception("Không tìm thấy hình ảnh"));
            product.setImageUrl(uploadFile.getThumbUrl());
        }
        return productRepository.save(product);
    }

    @Override
    public ProductCategory addProductCategory(ProductCategory productCategory) throws Exception {
        User user = getUser();
        if (user.getRoles().get(0).getName() == RoleName.ROLE_USER) {
            throw new Exception(Translator.toLocale("access_denied"));
        }
        if(productCategoryRepository.existsByTitle(productCategory.getTitle())) {
            throw new Exception("Category đã tồn tại");
        }
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public List<ProductCategory> getAllProductCategory() throws Exception {
        return productCategoryRepository.findAll();
    }

}

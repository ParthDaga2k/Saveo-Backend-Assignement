package com.saveo.Assignment.Services;

//import com.saveo.Assignment.Repositories.ProductRepo;
import com.saveo.Assignment.Repositories.ProductRepository;
import com.saveo.Assignment.helper.CSVHelper;
import com.saveo.Assignment.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FileUploadService {

    @Autowired
    ProductRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Product> product_list = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(product_list);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

//    public List<Product> getAllTutorials() {
//        return repository.findAll();
//    }
}


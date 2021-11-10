package com.saveo.Assignment.Services;

import com.saveo.Assignment.Repositories.ProductRepository;
import com.saveo.Assignment.models.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

    @Autowired
    ProductRepository repository;

    public List<Product> searchMedicineByName(String medicineName){
        List<Product> productList = repository.findBycNameContaining(medicineName);
        return productList;
    }

    public Product searchMedicineById(Integer uniqueId) {
        Product product = repository.findBycUniqueCode(uniqueId);
        return product;
    }
}

package com.saveo.Assignment;

import com.saveo.Assignment.Services.FileUploadService;
import com.saveo.Assignment.Services.MedicineService;
import com.saveo.Assignment.Services.OrderService;
import com.saveo.Assignment.helper.CSVHelper;
import com.saveo.Assignment.models.OrderRequest;
import com.saveo.Assignment.models.Product;
import com.saveo.Assignment.models.ResponseMessage;
import javassist.bytecode.ExceptionsAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    FileUploadService fileService;

    @Autowired
    MedicineService medicineService;

    @Autowired
    OrderService orderService;

    @GetMapping("")
    public String printHello(){
        return "Hello World";
    }

    @PostMapping("/uploadCSV")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {

        System.out.println("API HIT!");
        String message = "";
        System.out.println(file.getContentType());
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    @GetMapping("/searchMedicine")
    public ResponseEntity<ResponseMessage> searchMedicine(@RequestParam("name") String medicineName) {

        String message = "";
        try {
            List<Product> productList = medicineService.searchMedicineByName(medicineName);
            message = "fetched medicines!";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, productList));
        } catch (Exception e) {
            System.out.println("Searching failed! " + e.getMessage());
            message = "Searching failed!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/getMedicineDetails")
    public ResponseEntity<ResponseMessage> MedicineDetails(@RequestParam("unique_id") Integer UniqueId) {

        String message = "";
        try {
            Product product = medicineService.searchMedicineById(UniqueId);
            if(product == null){
                message = "No entry found!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            } else {
            message = "fetched medicine!";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, product));
            }
        } catch (Exception e) {
            System.out.println("Searching failed! " + e.getMessage());
            message = "Searching failed!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }


    @PostMapping("/placeorder")
    public ResponseEntity<ResponseMessage> searchMedicine(@RequestBody OrderRequest request) {

        String message = "";
        try{
            message = orderService.placeOrder(request);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e){
            message = "Exception:" + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
}

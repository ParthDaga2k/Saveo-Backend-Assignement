package com.saveo.Assignment.helper;

import com.saveo.Assignment.models.Product;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"c_name","c_batch_no","d_expiry_date","n_balance_qty","c_packaging",	"c_unique_code","c_schemes","n_mrp","c_manufacturer","hsn_code","id"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!(TYPE.equals(file.getContentType()) || file.getContentType().equals("application/vnd.ms-excel"))) {
            return false;
        }

        return true;
    }

    public static List<Product> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Product> product_list = new ArrayList<Product>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            for (CSVRecord csvRecord : csvRecords) {
                Product product = new Product(
                        csvRecord.get("c_name"),
                        csvRecord.get("c_batch_no"),
                        csvRecord.get("d_expiry_date"),
                        Integer.parseInt(csvRecord.get("n_balance_qty")),
                        csvRecord.get("c_packaging"),
                        Integer.parseInt(csvRecord.get("c_unique_code")),
                        csvRecord.get("c_schemes"),
                        Double.parseDouble(csvRecord.get("n_mrp")),
                        csvRecord.get("c_manufacturer"),
                        Integer.parseInt(csvRecord.get("hsn_code")),
                        Long.parseLong(csvRecord.get("id"))
                );

                product_list.add(product);
            }

            return product_list;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}

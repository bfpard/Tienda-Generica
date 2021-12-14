package Tienda.Generica.Config;

import Tienda.Generica.Entity.Producto;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"codigoproducto", "nombreproducto", "NITProveedor", "preciocompra","IVA", "precioventa"};

    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<Producto> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader,
                        CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Producto> productoList = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Producto producto = new Producto(
                        Integer.parseInt(csvRecord.get("codigoproducto")),
                        csvRecord.get("nombreproducto"),
                        csvRecord.get("NITProveedor"),
                        csvRecord.get("preciocompra"),
                        csvRecord.get("IVA"),
                        csvRecord.get("precioventa")
                );
                
                productoList.add(producto);
            }

            return productoList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream tutorialsToCSV(List<Producto> developerTutorialList) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Producto developerTutorial : developerTutorialList) {
                List<String> data = Arrays.asList(
                        String.valueOf(developerTutorial.getId()),
                        developerTutorial.getNombre(),
                        developerTutorial.getNit(),
                        developerTutorial.getPrecioCompra(),
                        developerTutorial.getIva(),
                        developerTutorial.getPrecioVenta()
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }

}

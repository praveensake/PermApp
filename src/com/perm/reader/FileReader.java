package com.perm.reader;


import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class FileReader {
    final static Logger logger = Logger.getLogger(FileReader.class);

    public static void main(String[] args) {

        URL resource = FileReader.class.getClassLoader().getResource("PERM_Data_FY2023_Q1.xlsx");

        StopWatch watch = new StopWatch();
        watch.start();

        try {
            InputStream is = new FileInputStream(new File(resource.toURI()));
            ReadableWorkbook wb = new ReadableWorkbook(is);

            Sheet sheet = wb.getSheet(0).get();

            List<Row> rows1 = sheet.read();

            System.out.println("Total rows: " + rows1.size());

            int cols = rows1.get(0).getCellCount();

            System.out.println("Total columns: " + cols);


            try (Stream<Row> rows = sheet.openStream()) {


                rows.skip(1).forEach(r -> {

                    r.getCellCount();
                   // BigDecimal num = r.getCellAsNumber(0).orElse(null);
                    String str1 = r.getCellAsString(0).orElse(null);
                    String str2 = r.getCellAsString(1).orElse(null);

                    LocalDateTime dateTime = r.getCellAsDate(2).orElse(null);


                    System.out.println("Cell str value :: " + str1);
                    System.out.println("Cell str value :: " + str2);
                    if(dateTime != null)
                        System.out.println("Cell date value: " + dateTime.getMonthValue() + "/" + dateTime.getDayOfMonth() + "/" + dateTime.getYear());

                });

            } catch (Exception e) {
                e.printStackTrace();
            }
                watch.stop();
                System.out.println("Processing time :: " + watch.getTime(TimeUnit.MILLISECONDS));


        }catch(Exception e){
            logger.error("Error while reading data from file: ", e);
        }





    }
}

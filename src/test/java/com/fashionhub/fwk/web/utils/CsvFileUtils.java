package com.fashionhub.fwk.web.utils;

import com.fashionhub.fwk.web.dto.PullRequestInfoDTO;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class CsvFileUtils {

    private static final Logger log = LoggerFactory.getLogger(CsvFileUtils.class);

    private static final String [] PR_CSV_HEADERS = new String[] {"PR Name", "Created Date", "Author"};

    public static void saveCsvFile(String repository, List<PullRequestInfoDTO> pullRequestList) {

        try {
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader(PR_CSV_HEADERS)
                    .build();

            File csvFile = new File(String.format("reports/%s_pull_requests.csv", repository));
            csvFile.createNewFile();

            try (final FileWriter fw = new FileWriter(csvFile);
                 final CSVPrinter printer = new CSVPrinter(fw, csvFormat)) {

                for (var prInfo : pullRequestList) {
                    printer.printRecord(prInfo.getName(), prInfo.getCreatedDate(), prInfo.getAuthor());
                }

                printer.flush();
            }

        } catch (IOException e) {
            log.error("Error writing record", e);
        }
    }
}

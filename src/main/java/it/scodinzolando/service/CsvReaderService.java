package it.scodinzolando.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;

@Service
public class CsvReaderService {

	public List<String[]> csvReader(String csv, char separator, char quote)
			throws IOException {
		// create CSVReader object
		CSVReader reader = new CSVReader(new FileReader(csv), separator, quote);

		// read all lines at once
		List<String[]> records = new ArrayList<String[]>();
		// read line by line
		String[] record = null;
		// skip header row
		reader.readNext();

		while ((record = reader.readNext()) != null) {
			records.add(record);
		}
		reader.close();
		return records;
	}
}

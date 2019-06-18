/*
 * MIT License
 *
 * Copyright (c) 2019.
 *  Author: ManuNellutla
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.etrue.challenge.util;

import com.etrue.challenge.controllers.CareersController;
import com.etrue.challenge.dao.EmployeeRepository;
import com.etrue.challenge.model.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVReader {


    private final static Logger LOGGER = LoggerFactory.getLogger(CSVReader.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    public void setAddBookRepository (EmployeeRepository employeeRepository){

        this.employeeRepository = employeeRepository;
    }

    /**
     *
     * @param fileName
     * @return
     */
    public void importCsv(String fileName) throws IOException {

        String fullpath = getClass().getClassLoader().getResource(fileName).getPath();
        Reader in = new FileReader(fullpath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
        List<Employee> employees = new ArrayList<>();
        Employee emp = new Employee();
        for(CSVRecord rec : records){
           employeeRepository.save(new Employee(rec.get("first_name"),
                   rec.get("last_name"),
                   Integer.parseInt(rec.get("age")),
                   rec.get("state")
           ));
        }
        LOGGER.info("Number of Employees in the list {}",employees.size());
    }

    public static void main(String[] args) throws IOException {
        new CSVReader().importCsv("data.csv");

    }
}

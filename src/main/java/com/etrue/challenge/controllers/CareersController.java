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

package com.etrue.challenge.controllers;

import com.etrue.challenge.model.Career;
import com.etrue.challenge.model.CompanyEmployeeStatistics;
import com.etrue.challenge.services.CareerDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller providing mappings for career api operations.
 *
 * @author ManuNellutla
 *
 *
 */
@RestController
@RequestMapping(path = "/api/v1/career")
@Api(value = "Careers info", description = "Careers Api. Operations to get career details and CRUD operations", tags = {"career-info"})
public class CareersController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CareersController.class);

    public CareersController() {
    }

    private CareerDataService careerDataService;

    /**
     *  <p>This method sets career data service.</p>
     * @param careerDataService
     */
    @Autowired
    public void setCareerDataService(CareerDataService careerDataService) {
        this.careerDataService = careerDataService;
    }

    /**
     * Operation to retrieve all careers from career entity table. This is a get all operation using GET verb.
     * @return returns a list of {@link Career}
     */
    @ApiOperation(value = "View a list of careers",
            notes="Operation gets all the careers in the careers table.",
            response = Career.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/careers")
    public ResponseEntity getCareers() {
        LOGGER.info("Entering > Get Careers Data");
        return ResponseEntity.ok(careerDataService.getCareers());

    }

    /**
     * Operation to get career by ID.
     * @param id career Id is a numeric value
     * @return
     */
    @ApiOperation(value = "Display a career by ID (Not Implemented)",
            notes="This is a placeholder and is not implemented. ",
            response = Career.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/careers/{id}")
    public ResponseEntity getCareer(@PathVariable String id) {
        return ResponseEntity.ok("Sucess");
    }

    @ApiOperation(value = "Display an employee career", response = CompanyEmployeeStatistics.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping(value = "/history/{employeeid}")
    public ResponseEntity retrieveId(@PathVariable String employeeid) {
        return ResponseEntity.ok(careerDataService.getCareersByEmployeeId(Long.parseLong(employeeid)));
    }
}

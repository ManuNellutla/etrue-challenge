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

import com.etrue.challenge.model.CompanyEmployeeStatistics;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/admin")
@Api(value = "Admin Tasks", description = "Admin Api for self service tasks. Needs admin credentials", tags = {"admin-tasks"})
public class AdminController {

    public AdminController() {
    }

    @ApiOperation(value = "Dynamically generate employee-company-career dataset and load it into company_emp_stats table.",
            notes = "This operation is a self service operation and needs admin credentials. Expansion of this operation" +
                    "OAUTH API key / OIDC authorization flow to evaluate authorization. <p> For the purpose of this exercise" +
                    "basic raw credential evaluation is used. username='admin/password='admin'.",
            response = CompanyEmployeeStatistics.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping(path = "/genDataSet/")
    public ResponseEntity generateDataSet(@RequestParam("username") String uname, @RequestParam("password") String password) {
        return ResponseEntity.ok("success");
    }
}

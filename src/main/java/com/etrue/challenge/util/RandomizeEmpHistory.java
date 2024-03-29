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
import com.etrue.challenge.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RandomizeEmpHistory {

    private final static Logger LOGGER = LoggerFactory.getLogger(RandomizeEmpHistory.class);

    /**
     *
     * @param emp
     * @return
     */
    public Employee randomizeHistory(Employee emp){

        //validate Age
        if(emp.getAge() > 18){


        }else{
            LOGGER.info("Employee {} is too young to work. Age :{}",emp.getfName(),emp.getAge());
        }

        return emp;
    }
}

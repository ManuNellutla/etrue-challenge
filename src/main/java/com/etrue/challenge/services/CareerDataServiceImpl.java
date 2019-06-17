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

package com.etrue.challenge.services;

import com.etrue.challenge.dao.CareerRepository;
import com.etrue.challenge.model.Career;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerDataServiceImpl implements CareerDataService {

    @Autowired
    private CareerRepository careerRepository;

    @Autowired
    public void setAddBookRepository (CareerRepository careerRepository){

        this.careerRepository = careerRepository;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Career> getCareers() {
        return careerRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public List<Career> getCareersByEmployeeId(long id) {
        return null;
    }
}

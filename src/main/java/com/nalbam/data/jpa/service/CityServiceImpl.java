/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nalbam.data.jpa.service;

import com.nalbam.data.jpa.domain.City;
import com.nalbam.data.jpa.domain.HotelSummary;
import com.nalbam.data.jpa.repository.CityRepository;
import com.nalbam.data.jpa.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Component("cityService")
@Transactional
class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Page<City> findAll() {
        return this.cityRepository.findAll(null);
    }

    @Override
    public Page<City> findCities(String name, Pageable pageable) {
        Assert.notNull(name, "Name must not be null");

        String country = "";
        int splitPos = name.lastIndexOf(",");

        if (splitPos >= 0) {
            country = name.substring(splitPos + 1);
            name = name.substring(0, splitPos);
        }

        return this.cityRepository.findByNameContainingAndCountryContainingAllIgnoringCase(name.trim(), country.trim(), pageable);
    }

    @Override
    public City getCity(String name, String country) {
        Assert.notNull(name, "Name must not be null");
        Assert.notNull(country, "Country must not be null");
        return this.cityRepository.findByNameAndCountryAllIgnoringCase(name, country);
    }

    @Override
    public Page<HotelSummary> getHotels(City city, Pageable pageable) {
        Assert.notNull(city, "City must not be null");
        return this.hotelRepository.findByCity(city, pageable);
    }

}

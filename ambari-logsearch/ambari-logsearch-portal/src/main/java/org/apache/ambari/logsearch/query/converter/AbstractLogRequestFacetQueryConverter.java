/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ambari.logsearch.query.converter;

import org.apache.ambari.logsearch.model.request.impl.BaseLogRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.FacetOptions;
import org.springframework.data.solr.core.query.SimpleFacetQuery;
import org.springframework.data.solr.core.query.SimpleFilterQuery;
import org.springframework.data.solr.core.query.SimpleStringCriteria;

public abstract class AbstractLogRequestFacetQueryConverter<SOURCE extends BaseLogRequest> extends AbstractConverterAware<SOURCE, SimpleFacetQuery>{

  @Override
  public SimpleFacetQuery convert(SOURCE request) {
    String fromValue = StringUtils.isNotEmpty(request.getFrom()) ? request.getFrom() : "*";
    String toValue = StringUtils.isNotEmpty(request.getTo()) ? request.getTo() : "*";
    Criteria criteria = new SimpleStringCriteria("*:*");
    SimpleFacetQuery facetQuery = new SimpleFacetQuery();
    facetQuery.addCriteria(criteria);
    SimpleFilterQuery simpleFilterQuery = new SimpleFilterQuery();
    simpleFilterQuery.addCriteria(new SimpleStringCriteria(getDateTimeField() + ":[" + fromValue +" TO "+ toValue+ "]" ));
    facetQuery.addFilterQuery(simpleFilterQuery);
    FacetOptions facetOptions = new FacetOptions();
    facetOptions.setFacetMinCount(1);
    facetOptions.setFacetSort(getFacetSort());
    appendFacetOptions(facetOptions, request);
    facetQuery.setFacetOptions(facetOptions);
    facetQuery.setRows(0);
    appendFacetQuery(facetQuery, request);
    return facetQuery;
  }

  public abstract FacetOptions.FacetSort getFacetSort();

  public abstract String getDateTimeField();

  public void appendFacetQuery(SimpleFacetQuery facetQuery, SOURCE request) {
  }

  public void appendFacetOptions(FacetOptions facetOptions, SOURCE request) {
    facetOptions.setFacetLimit(-1);
  }
}

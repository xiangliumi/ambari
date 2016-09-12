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

import org.apache.ambari.logsearch.model.request.impl.ServiceLogRequest;
import org.apache.solr.client.solrj.SolrQuery;
import org.easymock.EasyMockRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.solr.core.DefaultQueryParser;
import org.springframework.data.solr.core.query.SimpleQuery;

import java.util.HashMap;
import java.util.Map;

@RunWith(EasyMockRunner.class)
public class BaseServiceLogRequestQueryConverterTest {

  private BaseServiceLogRequestQueryConverter underTest;

  private Map<String, String> fieldMap = new HashMap<>();

  private Map<String, String> fieldTypeMap = new HashMap<>();

  @Before
  public void setUp() {
    underTest = new BaseServiceLogRequestQueryConverter();
    fieldMap.put("case_id", "key_lower_case");
    fieldMap.put("cluster", "key_lower_case");
    fieldMap.put("bundle_id", "key_lower_case");
    fieldTypeMap.put("key_lower_case", "{\"name\":\"key_lower_case\",\"class\":\"solr.TextField\",\"sortMissingLast\":true," +
      "\"omitNorms\":true,\"analyzer\":{\"tokenizer\":{\"class\":\"solr.KeywordTokenizerFactory\"}," +
      "\"filters\":[{\"class\":\"solr.LowerCaseFilterFactory\"}]}}");
  }

  @Test
  public void testConvertRequest() {
    // GIVEN
    ServiceLogRequest logRequest = new ServiceLogRequest();
    logRequest.setLevel("FATAL,ERROR,WARN,UNKNOWN");
    logRequest.setStartIndex("0");
    logRequest.setPage("0");
    //logRequest.setPageSize("25");
    logRequest.setFrom("2016-09-13T22:00:01.000Z");
    logRequest.setTo("2016-09-14T22:00:01.000Z");
    logRequest.setMustBe("logsearch_app,secure_log");
    logRequest.setMustNot("hst_agent,system_message");
    logRequest.setFileName("myfile");
    logRequest.setComponentName("component");
    logRequest.setHostName("logsearch.com}");

    // WHEN
    SimpleQuery query = underTest.convert(logRequest);
    DefaultQueryParser defaultQueryParser = new DefaultQueryParser();
    SolrQuery solrQuery = defaultQueryParser.doConstructSolrQuery(query);
    // THEN
    // TODO extends this test case later
  }


}

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
package org.apache.ambari.logsearch.solr;

public class SolrConstants {

  private SolrConstants() {
  }


  public class CommonLogConstants {
    private CommonLogConstants() {
    }
    public static final String ID = "id";
    public static final String SEQUENCE_ID = "seq_num";
  }

  public class ServiceLogConstants {

    private ServiceLogConstants() {
    }

    public static final String BUNDLE_ID = "bundle_id";
    public static final String LOGTIME = "logtime";
    public static final String COMPONENT = "type";
    public static final String LOG_MESSAGE = "log_message";
    public static final String KEY_LOG_MESSAGE = "key_log_message";
    public static final String HOST = "host";
    public static final String LEVEL = "level";
    public static final String THREAD_NAME = "thread_name";
    public static final String LOGGER_NAME = "logger_name";
    public static final String FILE = "file";
    public static final String LINE_NUMBER = "line_number";
    public static final String PATH = "path";
  }

  public class AuditLogConstants {
    private AuditLogConstants() {
    }

    public static final String AUDIT_COMPONENT = "repo";
    public static final String AUDIT_EVTTIME = "evtTime";
    public static final String AUDIT_REQUEST_USER = "reqUser";
    public static final String AUDIT_RESOURCE = "resource";
  }
}

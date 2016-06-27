/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

var App = require('app');

App.MainAssembliesServiceGroupController = Em.Controller.extend({

  name: 'mainAssembliesServiceGroupController',

  startServiceGroup: function () {
    var self = this;
    return App.showConfirmationPopup(function () {
      return App.ajax.send({
        name: 'service_group.change_state',
        sender: self,
        data: {
          id: self.get('content.id'),
          state: 'STARTED'
        }
      });
    }, Em.I18n.t('services.service.startAll.confirmMsg').format(this.get('content.serviceGroupName')));
  },

  stopServiceGroup: function () {
    var self = this;
    return App.showConfirmationPopup(function () {
      return App.ajax.send({
        name: 'service_group.change_state',
        sender: self,
        data: {
          id: self.get('content.id'),
          state: 'INSTALLED'
        }
      });
    }, Em.I18n.t('services.service.stopAll.confirmMsg').format(this.get('content.serviceGroupName')));
  }

});